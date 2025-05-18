<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Marks Form</title>
</head>
<body>
    <h1>Enter Marks</h1>
    <form method="post" action="calculate">
        <label>Science Marks:</label>
        <input type="number" name="scienceMarks" required><br><br>

        <label>Maths Marks:</label>
        <input type="number" name="mathsMarks" required><br><br>

        <label>English Marks:</label>
        <input type="number" name="englishMarks" required><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
