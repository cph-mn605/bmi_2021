package web.commands;

import business.entities.User;
import business.exceptions.UserException;
import business.services.BmiUtil;
import business.services.BmiFacade;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalcBMICommand extends CommandUnprotectedPage
{
    private BmiFacade bmiFacade;

    public CalcBMICommand(String pageToShow) {
        super(pageToShow);
        this.bmiFacade = new BmiFacade(database);
    }

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws UserException {
        HttpSession session = request.getSession();
        User user;
        int user_id = 1; //TODO: skal laves dynamisk ift, login

        if(session.getAttribute("user") != null) {
            user = (User)session.getAttribute("user");
            user_id = user.getId();
        }
        else {

        }

        double height = 0.0;
        double weight = 0.0;
        double bmi = 0.0;
        String category = "";
        String gender = request.getParameter("gender");
        int sport_id = Integer.parseInt(request.getParameter("sport"));

        String[] hobbies = request.getParameterValues("hobby");
        List<String> hobbyListString = null;
        if (hobbies != null) {
            hobbyListString = Arrays.asList(hobbies);
        }

        List<Integer> hobbyListIntergers = new ArrayList<>();

        for (String hobbyListItem : hobbyListString)
        {
         hobbyListIntergers.add(Integer.parseInt(hobbyListItem));
        }

        try {

            height = Double.parseDouble(request.getParameter("height"));
            weight = Double.parseDouble(request.getParameter("weight"));
        }
        catch (NumberFormatException ex) {
            request.setAttribute("error", "Husk at du skal have 2 heltal i formularen");
            return "index";
            //throw new UserException("Husk at du skal have 2 heltal i formularen");
        }

        bmi = weight / ((height / 100) * (height / 100));
        bmi = BmiUtil.calcBMI(height,weight);

        category = BmiUtil.getCategory(bmi);

        request.setAttribute("bmi", String.format("%.2f",bmi));
        request.setAttribute("height", height);
        request.setAttribute("weight", weight);
        request.setAttribute("category", category);
        request.setAttribute("gender", gender);
        request.setAttribute("sport_id",sport_id);
        request.setAttribute("hobbies", hobbyListIntergers);

        bmiFacade.insertBmiEntry(bmi, height, weight,category,gender,sport_id, user_id, hobbyListIntergers);

        return pageToShow;
    }
}

