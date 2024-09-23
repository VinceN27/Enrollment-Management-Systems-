<!DOCTYPE html>
<html>
<head>
    <title>Insert title here</title>
</head>
<body>
    <h1>ENROLLMENT PAGE</h1>
    
    
    
    
    
    <form action="Redirect" method="get">
        <label for="course">Choose a course:</label>
        <select id="course" name="course">
            <option value="ACC11">ACC11-</option>
            <option value="AFR12">AFR12-</option>
            <option value="CST00">CST00-</option>
            <option value="CST01">CST01-</option>
            <option value="CST02">CST02-</option>
            <option value="CST03">CST03-</option>
            <option value="CST04">CST04-</option>
            <option value="CST05">CST05-</option>
            <option value="CST06">CST06-</option>
            <option value="CST07">CST07-</option>
            <option value="CST08">CST08-</option>
            <option value="CST0A">CST0A-</option>
            <option value="CST10">CST10-</option>
            <option value="CST13">CST13-</option>
            <option value="CST14">CST14-</option>
            <option value="CST17">CST17-</option>
            <option value="CST19">CST19-</option>
            <option value="CST35">CST35-</option>
            <option value="CST36">CST36-</option>
            <option value="CST42">CST42-</option>
            <option value="CST47">CST47-</option>
            <option value="CST48">CST48-</option>
            <option value="cst55">cst55-</option>
            <option value="CST71">CST71-</option>
            <option value="ENG01">ENG01-</option>
            <option value="ENG25">ENG25-</option>
            <option value="MATH0">MATH0-</option>
            <option value="MATH2">MATH2-</option>
            <option value="MATH3">MATH3-</option>
            <option value="PSY35">PSY35-</option>
        </select>
        
        
        <label for="grade">Grade:</label>
        <select id="grade" name="grade">
            <option value="A">A.</option>
            <option value="B">B.</option>
            <option value="C">C.</option>
            <option value="D">D.</option>
            <option value="F">F.</option>
        </select>
        
        
        
        <br><br>
        <input type="submit" name="action" value="drop">
        <input type="submit" name="action" value="enroll">
    </form>
    
    
   
    <table>
        <tr>
            <td>
                <form action="validateLogin" method="get">
                    <input type="hidden" name="action" value="exit">
                    <button type="submit">Exit</button>
                </form>
            </td>
        </tr>
    </table>
</body>
</html>
