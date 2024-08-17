package lk.ijse.stumanagement.controllers;


import jakarta.json.JsonException;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.stumanagement.dao.StudentDataProcess;
import lk.ijse.stumanagement.dto.StudentDTO;
import lk.ijse.stumanagement.util.UtilProcess;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/student"
//        initParams = {
//          @WebInitParam(name = "driver-class",value = "com.mysql.cj.jdbc.Driver"),
//          @WebInitParam(name = "dbURL",value = "jdbc:mysql://localhost:3306/aad67JavaEE?createDatabaseIfNotExist=true"),
//          @WebInitParam(name = "dbUserName",value = "root"),
//          @WebInitParam(name = "dbPassword",value = "mysql"),
//        }
,loadOnStartup = 2)
public class StudentController extends HttpServlet {

    static Logger logger = LoggerFactory.getLogger(StudentController.class);

    Connection connection;

    /*static String SAVE_STUDENT = "INSERT INTO Student (id,name,city,email,level) VALUES (?,?,?,?,?)";
    static String UPDATE_STUDENT = "UPDATE Student SET name=?, city=?, email=?, level=? WHERE id=?";
    static String GET_STUDENT = "SELECT * FROM Student WHERE id=?";
    static String DELETE_STUDENT = "DELETE FROM Student WHERE id=?";*/


    @Override
    public void init() throws ServletException {

        // info log
        logger.info("Initializing StudentController with call init method");

        // trace log
        logger.trace("Init called");

        try {

            // web.xml eka athule thiyena context params tike values tika gannava getInitParameter() method eken
            /*var driverClass = getServletContext().getInitParameter("driver-class");
            var dbURL = getServletContext().getInitParameter("dbURL");
            var userName = getServletContext().getInitParameter("dbUserName");
            var password = getServletContext().getInitParameter("dbPassword");*/

            // Get configs from servlet
            /*var driverClass = getServletConfig().getInitParameter("driver-class");
            var dbURL = getServletConfig().getInitParameter("dbURL");
            var userName = getServletConfig().getInitParameter("dbUserName");
            var password = getServletConfig().getInitParameter("dbPassword");*/

            // Log initialization parameters (for debugging purposes)
            System.out.println("Initializing database connection");
           /* System.out.println("Driver Class: " + driverClass);
            System.out.println("Database URL: " + dbURL);
            System.out.println("Database Username: " + userName);
            System.out.println("Database Password: " + password);*/




            // ======= after create connection pool , this is the step 3 ===========


            // connection pool eken ganna connection eka thiya ganna space ekak hadanava
            var ctx = new InitialContext();

            // lookup karala ganna resourse eka oonama type venna puluvan nisa DataSource valata narrow cast kara gannava
            DataSource pool = (DataSource) ctx.lookup("java:comp/env/jdbc/stuRegistration");

            // Load the driver class
            /*Class.forName(driverClass);*/

            // Establish the database connection
            /*this.connection = DriverManager.getConnection(dbURL, userName, password);*/
            this.connection = pool.getConnection();

            // Log successful connection
            System.out.println("Database connection established successfully");

        } catch (NamingException | SQLException e) {

            // error log
            logger.error("Init faild with ", e.getMessage());

            e.printStackTrace();
        }
    }



    // save student


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // mata handle karanna thiyena request eka athule json thiyenavada kiyala balanava
        // mulinma lower case karanava
        /*if(!req.getContentType().toLowerCase().startsWith("application/json") || req.getContentType() == null){ // me method eka assata json enavada kiyala check karanava

            // send error to the frontend
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE);
        }*/

        //=================== JSON PROCESS ================ Json P

        // process
/*
        BufferedReader reader = req.getReader(); // request eka kiyawanava
        StringBuilder sb = new StringBuilder(); // aluthin String builder ekak hada ganavva
        var writer = resp.getWriter(); // yawanna one response eka writer kiyala variable ekakata da gannava

        // line by line read karanava. ethakota api hadapu StringBuilder ekata ee line eka append veneva
        reader.lines().forEach(line -> sb.append(line + "\n"));
        System.out.println(sb);
        // response ekata yawanawa sb eka
        writer.write(sb.toString());
        writer.close();

        //me kramadei apita mokakhari thani data value ekak ganna unoth string vidiyata ganna one nisa apita split karanna venava me kramadi..eeka karadarai
*/


        // === JSON manipulate with Parson ===

        // Json Object - when request is Json Object ( api postman eken Json object ekak ewaddi )
/*

        JsonReader reader = Json.createReader(req.getReader()); //ena request eka read karanawa
        JsonObject jsonObject = reader.readObject(); // json object eka read karanava

        System.out.println(jsonObject.getString("name")); //json object eken values adala ganava
*/


        // Json Array - when request is Json Array ( api postman eken Json array ekak ewaddi )
/*

        JsonReader reader = Json.createReader(req.getReader()); //ena request eka read karanawa
        JsonArray jArray = reader.readArray(); // json array eka read karanava

        for (int i = 0; i < jArray.size(); i++) {
            JsonObject jsonObject = jArray.getJsonObject(i);
            System.out.println(jsonObject.getString("name"));
        }
*/


        //========================= JSON BIND ===================== Json B

        //process

        // when request is Json Object ( api postman eken Json object ekak ewaddi )
/*

        String id = UUID.randomUUID().toString();
        Jsonb jsonb = JsonBuilder.create(); //json bind type object ekak create kara gannava
        StudentDTO studentDTO = jsonb.fromJson(req.getReader(), StudentDTO.class);
        studentDTO.setId(id);
        System.out.println(studentDTO);
*/

        // when request is Json Array ( api postman eken Json array ekak ewaddi )
/*

        Jsonb jsonb = JsonbBuilder.create(); //json bind type object ekak create kara gannava
        List<StudentDTO> studentDTOList = jsonb.fromJson(req.getReader(),new ArrayList<StudentDTO>(){
        }.getClass().getGenericSuperclass());
        studentDTOList.forEach(System.out::println);
*/


        //====================================================================================================

        // start to save student

        // ****** before divide layers ******

       /* if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_UNSUPPORTED_MEDIA_TYPE); //send error
            return;
        }

        try {
            String id = UUID.randomUUID().toString();
            Jsonb jsonb = JsonbBuilder.create();    //json bind type object ekak create kara gannava
            StudentDTO studentDTO = jsonb.fromJson(req.getReader(), StudentDTO.class);
            studentDTO.setId(id);
            //System.out.println("Received student data: " + studentDTO);

            // Check if connection is null
            if (this.connection == null) {
                throw new ServletException("Database connection is not initialized.");
            }

            var ps = connection.prepareStatement(SAVE_STUDENT);

            ps.setString(1, studentDTO.getId());
            ps.setString(2, studentDTO.getName());
            ps.setString(3, studentDTO.getCity());
            ps.setString(4, studentDTO.getEmail());
            ps.setString(5, studentDTO.getLevel());

            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                resp.getWriter().write("Student Saved");
                System.out.println("Received student data: " + studentDTO);
            } else {
                resp.getWriter().write("Student Not Saved");
            }

        } catch (SQLException e) {
            throw new RuntimeException("Failed to persist student data", e);
        }*/


        // ****** after divide layers ******

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {

            // debug log
            logger.debug("Call do post method");

            resp.sendError(HttpServletResponse.SC_BAD_REQUEST); //send error
            return;
        }

        try (var writer = resp.getWriter()){ // this is called as try with resource

            // Create a JSONb object
            Jsonb jsonb = JsonbBuilder.create();    //json bind type object ekak create kara gannava

            // Deserialization
            // Assign DTO/model to a JSONb object
            StudentDTO studentDTO = jsonb.fromJson(req.getReader(), StudentDTO.class);

            // Set the id using UtilProcess
            studentDTO.setId(UtilProcess.generateId());

            var saveData = new StudentDataProcess();

            if(saveData.saveStudent(studentDTO, connection)){
                writer.write("Student saved successfully");
                resp.setStatus(HttpServletResponse.SC_CREATED);
            }else {
                writer.write("Student save failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }


        } catch (JsonException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(e);
        }

    }


    // update student

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getContentType() == null || !req.getContentType().toLowerCase().startsWith("application/json")) {
            resp.sendError(HttpServletResponse.SC_BAD_REQUEST); //send error
             return;
        }

        try(var writer = resp.getWriter()) {

            var studentId = req.getParameter("id");
            Jsonb jsonb = JsonbBuilder.create();    //json bind type object ekak create kara gannava
            StudentDTO studentDTO = jsonb.fromJson(req.getReader(), StudentDTO.class);

            var updateData = new StudentDataProcess();

            if(updateData.updateStudent(studentId, studentDTO, connection)){
                System.out.println("Student updated successfully");
                writer.write("Student updated successfully");
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else {
                System.out.println("Student update failed");
                writer.write("Student update failed");
                resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (JsonException e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            e.printStackTrace();
        }

    }



    // get student details

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // ****** before divide layers ******

        /*var studentDTO = new StudentDTO();
        var studentId = req.getParameter("id");


        try(var writer = resp.getWriter()){

            var ps = connection.prepareStatement(GET_STUDENT);

            ps.setString(1, studentId);

            var resultSet = ps.executeQuery();

            while (resultSet.next()) {
                studentDTO.setId(resultSet.getString("id"));
                studentDTO.setName(resultSet.getString("name"));
                studentDTO.setCity(resultSet.getString("city"));
                studentDTO.setEmail(resultSet.getString("email"));
                studentDTO.setLevel(resultSet.getString("level"));
            }

            System.out.println(studentDTO);
            resp.getWriter().write("Get data successfully\n");

            resp.setContentType("application/json");
            var jsonb = JsonbBuilder.create();  //json bind type object ekak create kara gannava
            jsonb.toJson(studentDTO, writer);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/


        // ****** after divide layers ******

        var studentId = req.getParameter("id");

        var getData = new StudentDataProcess();

        try (var writer = resp.getWriter()){

            StudentDTO studentDTO = getData.getStudent(studentId, connection);
            System.out.println(studentDTO);

            resp.setContentType("application/json");
            Jsonb jsonb = JsonbBuilder.create();

            // Serialization
            jsonb.toJson(studentDTO, writer);

        }

    }



    // delete student

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try(var writer = resp.getWriter()) {

            var studentId = req.getParameter("id");

            var deleteStudent = new StudentDataProcess();

            if(deleteStudent.deleteStudent(studentId, connection)){
                System.out.println("Student deleted successfully");
                writer.write("Student deleted successfully");
                resp.setStatus(HttpServletResponse.SC_NO_CONTENT);
            }else {
                System.out.println("Student delete failed");
                writer.write("Student delete failed");
                resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
            }

        } catch (Exception e) {
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            throw new RuntimeException(e);
        }
    }
}