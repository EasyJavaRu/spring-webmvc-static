<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Parcel for ${parcel.owner}</title></head>
  <body>
  <h1>Parcel for ${parcel.owner}</h1>

  <form:form modelAttribute="parcel">
  <form:hidden path="id"/>
  <table>
    <tr>
          <td>Owner:</td>
          <td><form:input path="owner"/></td>
    </tr>
    <tr>
          <td>Weight:</td>
          <td><form:input path="weight"/></td>
     </tr>
     <tr>
          <td colspan="2"><input type="submit" value="Save Changes"/></td>
     </tr>
  </table>
  </form:form>
  </body>
</html>