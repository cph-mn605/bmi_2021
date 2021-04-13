<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <div class="row">
            <div class="col-sm-4"></div>
            <div class="col-sm-4">

            <h2>BMI beregner</h2>

            <form method="post" action="${pageContext.request.contextPath}/fc/bmiresult">
                <div class="form-group">
                    <label for="height">Højde i cm: </label>
                    <input id="height" name="height" type="text" class="form-control"/><br>
                </div>

                <div class="form-group">
                    <label for="weight">Vægt i kg: </label>
                <input id="weight" name="weight" type="text" class="form-control"/><br>
                </div>

                </br>

                <input type="radio" id="male" name="gender" value="male">
                <label for="male">Male</label><br>
                <input type="radio" id="female" name="gender" value="female">
                <label for="female">Female</label><br>

                <label for="sport">Din primære idræt:</label>

                <select name="sport" id="sport">
                    <option value="1">Fodbold</option>
                    <option value="2">Håndbold</option>
                    <option value="3">Golf</option>
                    <option value="4">Tennis</option>
                </select>

                </br>

                <input type="checkbox" id="hobby1" name="hobby1" value="Jeg går op i sund kost">
                <label for="vehicle1"> Jeg går op i sund kost</label><br>
                <input type="checkbox" id="hobby2" name="hobby2" value="Jeg har et sommerhus">
                <label for="vehicle2"> Jeg har et sommerhus</label><br>
                <input type="checkbox" id="hobb3" name="hobby3" value="Jeg har et kæledyr">
                <label for="vehicle3"> Jeg har et kæledyr</label>

                <br>


                <c:if test="${requestScope.error != null}">
                    <p style="color:red">
                            ${requestScope.error}
                    </p>
                </c:if>

                <button type="submit" class="btn btn-primary"> Beregn BMI</button>

            </form>


            </div>
            <div class="col-sm-4"></div>

        </div>



            <div style="margin-top: 3em;margin-bottom: 3em;">
                Main page for this 2. semester start project used at cphbusiness.dk
            </div>

            <c:if test="${sessionScope.role == 'employee' }">
                <p style="font-size: larger">This is what you can do,
                    since your are logged in as an employee</p>
                 <p><a href="fc/employeepage">Employee Page</a>
             </c:if>

             <c:if test="${sessionScope.role == 'customer' }">
                <p style="font-size: larger">This is what you can do, since your
                    are logged in as a customer</p>
                <p><a href="fc/customerpage">Customer Page</a>
            </c:if>

        </div>

    </jsp:body>
</t:genericpage>