
package question_bank_generation_system;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question_Bank_Generation_System  {
    private static final String URL = "jdbc:sqlserver://localhost:1433;databaseName=questiondb2";
    private static final String USER = "Project";
    private static final String PASS = "123456";

    public static void main(String[] args) {
        String physics1 = "question1.txt";
        String physics2 = "question2.txt";
         String physics3 = "question3.txt";
         String physics4 = "question4.txt";
         String physics5 = "question5.txt";
         String physics6 = "question6.txt";
         String physics7 = "question7.txt";
         String physics8 = "question8.txt";
          String physics9 = "question9.txt";
          String physics10 = "question10.txt";
           String physics11 = "question11.txt";
            String physics12 = "question12.txt";
           String physics13 = "question13.txt";
            String physics14 = "question14.txt";
             String physics15 = "question15.txt";
 String physics16 = "question16.txt";
 String physics17 = "question17.txt";
 String physics18 = "question18.txt";
 String physics19 = "question19.txt";
  String physics20 = "question20.txt";
   String physics21 = "question21.txt";
    String physics22 = "question22.txt";
     String physics23 = "question23.txt";
      String physics24 = "question24.txt";
       String physics25 = "question25.txt";
        String physics26 = "question26.txt";
      
     
 
        try (Connection con = DriverManager.getConnection(URL, USER, PASS)) {
           createQuestionsFile1(physics1, con);
            createQuestionsFile2(physics2, con);
            createQuestionsFile3(physics3, con);
            createQuestionsFile4(physics4, con);
            createQuestionsFile5(physics5, con);
            createQuestionsFile6(physics6, con);
            createQuestionsFile7(physics7, con);
             createQuestionsFile8(physics8, con);
             createQuestionsFile9(physics9, con);
             createQuestionsFile10(physics10, con);
             createQuestionsFile11(physics11, con);
             createQuestionsFile12(physics12, con);
              createQuestionsFile13(physics13, con);
              createQuestionsFile14(physics14, con);
              createQuestionsFile15(physics15, con);
              createQuestionsFile16(physics16, con);
              createQuestionsFile17(physics17, con);
              createQuestionsFile18(physics18, con);
              createQuestionsFile19(physics19, con);
              createQuestionsFile20(physics20, con);
              createQuestionsFile21(physics21, con);
              createQuestionsFile22(physics22, con);
               createQuestionsFile23(physics23, con);
                createQuestionsFile24(physics24, con); 
                createQuestionsFile25(physics25, con);
                 createQuestionsFile26(physics26, con);
                 
                
        } catch (SQLException e) {
            System.err.println("Database connection error: " + e.getMessage());
            e.printStackTrace();
        }
    }

 private static void createQuestionsFile1(String filePath, Connection con) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            for (float distance = 60; distance <= 80; distance += 5) {
                for (float time = 3; time <= 10; time++) {
                    float avgVelocity = distance / time;
                    float a1 = avgVelocity + 1;
                    float a2 = avgVelocity + 2;
                    float a3 = avgVelocity - 1;                
                    String mQuestion = String.format("What is the average velocity of a car that moved %.1f km in %.1f hours?", distance, time);
                    String answer = String.format("%.2f km/h", avgVelocity);

                    printWriter.println(mQuestion);
                    printWriter.println("A) " + answer);
                    printWriter.println(String.format("B) %.2f km/h", a1));
                    printWriter.println(String.format("C) %.2f km/h", a2));
                    printWriter.println(String.format("D) %.2f km/h", a3));
                    printWriter.println(); // Adding an empty line between questions

                    // Insert question into the database
                    String statement = "INSERT INTO Question1 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                        saveStmt.setString(1, mQuestion);
                        saveStmt.setString(2, String.format("%.2f km/h", avgVelocity));
                        saveStmt.setString(3, String.format("%.2f km/h", a1));
                        saveStmt.setString(4, String.format("%.2f km/h", a2));
                        saveStmt.setString(5, String.format("%.2f km/h", a3));
                        saveStmt.setString(6, answer);
                        saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                        saveStmt.setInt(8, 0);
                        saveStmt.setInt(9, 0);
                        saveStmt.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("SQL error while inserting question: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("File has been created: " + filePath);
        } catch (IOException e) {
            System.err.println("File writing error: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void createQuestionsFile2(String filePath, Connection con) {
        try (FileWriter fileWriter = new FileWriter(filePath);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {

            for (float time = 3; time <= 100; time++) {
                float distance = 110;
                float acceleration = (2 * distance) / (time * time);

                String mQuestion = "A car starts from rest and accelerates uniformly over a time of " + time + " seconds for a distance of " + distance + " meters. Determine the acceleration of the car.";
                String answer = String.format("%.2f m/s^2", acceleration);

                printWriter.println(mQuestion);
                printWriter.println("A) " + answer);
                printWriter.println(String.format("B) %.2f m/s^2", acceleration + 1));
                printWriter.println(String.format("C) %.2f m/s^2", acceleration + 2));
                printWriter.println(String.format("D) %.2f m/s^2", acceleration - 1));
                printWriter.println(); // Adding an empty line between questions

                // Insert question into the database
                String statement = "INSERT INTO Question2 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, mQuestion);
                    saveStmt.setString(2, String.format("%.2f m/s^2", acceleration));
                    saveStmt.setString(3, String.format("%.2f m/s^2", acceleration + 1));
                    saveStmt.setString(4, String.format("%.2f m/s^2", acceleration + 2));
                    saveStmt.setString(5, String.format("%.2f m/s^2", acceleration - 1));
                    saveStmt.setString(6, answer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            System.out.println("File has been created: " + filePath);
        } catch (IOException e) {
            System.err.println("File writing error: " + e.getMessage());
            e.printStackTrace();
        }
    }
    private static void createQuestionsFile3(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (int i = 0; i < 40; i++) {
            float initialVelocity = (float) (Math.random() * 20); 
            float finalVelocity = initialVelocity + (float) (Math.random() * (30 - initialVelocity));
            float time = (float) (Math.random() * 10); 
            float acceleration = (finalVelocity - initialVelocity) / time;
            String mQuestion = String.format("What is the acceleration of an object if its velocity changes from %.1f m/s to %.1f m/s in %.1f seconds?", initialVelocity, finalVelocity, time);
            String answer = String.format("A) %.1f m/s²", acceleration);
            printWriter.println(mQuestion);
            printWriter.println(answer);
            printWriter.println("B) " + String.format("%.1f m/s²", acceleration * 2));
            printWriter.println("C) " + String.format("%.1f m/s²", acceleration * 4));
            printWriter.println("D) " + String.format("%.1f m/s²", acceleration * 5));
            printWriter.println(); 
            // Insert question into the database
            String statement = "INSERT INTO Question3 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                saveStmt.setString(1, mQuestion);
                saveStmt.setString(2, String.format("%.1f m/s²", acceleration));
                saveStmt.setString(3, String.format("%.1f m/s²", acceleration * 2));
                saveStmt.setString(4, String.format("%.1f m/s²", acceleration * 4));
                saveStmt.setString(5, String.format("%.1f m/s²", acceleration * 5));
                saveStmt.setString(6, answer);
                saveStmt.setString(7, "A"); 
                saveStmt.setInt(8, 0);
                saveStmt.setInt(9, 0);
                saveStmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("SQL error while inserting question: " + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile4(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float acceleration = 20; acceleration <= 30; acceleration += 5) {
            for (float time = 3; time <= 10; time++) {
                float d = 0.5f * acceleration * time * time;
                float a1 = d + 1;
                float a2 = d + 2;
                float a3 = d - 1;
                String mQuestion = String.format("A car accelerates uniformly from rest at %.1f m/s². What distance does it cover in %.1f seconds?", acceleration, time);
                printWriter.println(mQuestion);
                String answer = "A) " + String.format("%.2f m", d); // Define the answer
                printWriter.println(answer);
                printWriter.println("B) " + String.format("%.2f m", a1));
                printWriter.println("C) " + String.format("%.2f m", a2));
                printWriter.println("D) " + String.format("%.2f m", a3));
                printWriter.println(); 
                // Insert question into the database
                String statement = "INSERT INTO Question4 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, mQuestion);
                    saveStmt.setString(2, String.format("%.2f m", d));
                    saveStmt.setString(3, String.format("%.2f m", a1));
                    saveStmt.setString(4, String.format("%.2f m", a2));
                    saveStmt.setString(5, String.format("%.2f m", a3));
                    saveStmt.setString(6, answer);
                    saveStmt.setString(7, "A");
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}

private static void createQuestionsFile5(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        float acceleration = 9.8f;
        int v = 0;
        for (float time = 3; time <= 1000; time++) {
            float distance = (v * time) + (0.5f * acceleration * time * time);
            float a1 = distance + 1;
            float a2 = distance + 2;
            float a3 = distance - 1;
            String mQuestion = String.format("To find the distance the ball falls in %.1f seconds, we can use the equation of motion for uniformly accelerated motion", time);
            printWriter.println(mQuestion);
            String answer = "A) " + String.format("%.2f m", distance);
            printWriter.println(answer);
            printWriter.println("B) " + String.format("%.2f m", a1));
            printWriter.println("C) " + String.format("%.2f m", a2));
            printWriter.println("D) " + String.format("%.2f m", a3));
            printWriter.println();
            String statement = "INSERT INTO Question4 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                saveStmt.setString(1, mQuestion);
                saveStmt.setString(2, String.format("%.2f m", distance));
                saveStmt.setString(3, String.format("%.2f m", a1));
                saveStmt.setString(4, String.format("%.2f m", a2));
                saveStmt.setString(5, String.format("%.2f m", a3));
                saveStmt.setString(6, answer);
                saveStmt.setString(7, "A");
                saveStmt.setInt(8, 0);
                saveStmt.setInt(9, 0);
                saveStmt.executeUpdate();
            } catch (SQLException e) {
                System.err.println("SQL error while inserting question: " + e.getMessage());
                e.printStackTrace();
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    } 
}

private static void createQuestionsFile6(String filePath, Connection con) {
           try (FileWriter fileWriter = new FileWriter(filePath);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
           int u=0;
            for (float acceleration = 20; acceleration <= 30; acceleration += 5) {
                for (float time = 3; time <= 10; time++) {
                    float velocity = u+ acceleration * time;
                    float option1 = velocity + 1;
                    float option2 = velocity + 2;
                    float option3 = velocity - 1;
                    String question = String.format("An object starts from rest and accelerates uniformly at %.1f m/s². What is its velocity after %.1f seconds?", acceleration, time);
                    printWriter.println(question);
                    String correctAnswer = String.format("%.2f m/s", velocity);
                    String answerA = "A) " + correctAnswer;
                    String answerB = "B) " + String.format("%.2f m/s", option1);
                    String answerC = "C) " + String.format("%.2f m/s", option2);
                    String answerD = "D) " + String.format("%.2f m/s", option3);
                    printWriter.println(answerA);
                    printWriter.println(answerB);
                    printWriter.println(answerC);
                    printWriter.println(answerD);
                    printWriter.println();
     String sql = "INSERT INTO Question6 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement saveStmt = con.prepareStatement(sql)) {
                        saveStmt.setString(1, question);
                        saveStmt.setString(2, correctAnswer);
                        saveStmt.setString(3, String.format("%.2f m/s", option1));
                        saveStmt.setString(4, String.format("%.2f m/s", option2));
                        saveStmt.setString(5, String.format("%.2f m/s", option3));
                        saveStmt.setString(6, correctAnswer);
                        saveStmt.setString(7, "A");
                        saveStmt.setInt(8, 0);
                        saveStmt.setInt(9, 0);
                        saveStmt.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("SQL error while inserting question: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("File has been created: " + filePath);
        } catch (IOException e) {
            System.err.println("File writing error: " + e.getMessage());
            e.printStackTrace();
        } 
}
private static void createQuestionsFile7(String filePath, Connection con) {
           try (FileWriter fileWriter = new FileWriter(filePath);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            for (float force = 20; force <= 30; force++) {
                for (float mass = 3; mass <= 10; mass++) {
                    float acceleration  = force/mass;
                    float option1 = acceleration + 1;
                    float option2 = acceleration + 2;
                    float option3 = acceleration - 1;
         String question = String.format("A force of %.1f N is applied to an object with a mass of %.1f kg. What is its acceleration?", force , mass );
                    printWriter.println(question);
                    String correctAnswer = String.format("%.2f m/s", acceleration);
                    String answerA = "A) " + correctAnswer;
                    String answerB = "B) " + String.format("%.2f m/s", option1);
                    String answerC = "C) " + String.format("%.2f m/s", option2);
                    String answerD = "D) " + String.format("%.2f m/s", option3);
                    printWriter.println(answerA);
                    printWriter.println(answerB);
                    printWriter.println(answerC);
                    printWriter.println(answerD);
                    printWriter.println();
                    String sql = "INSERT INTO Question7 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement saveStmt = con.prepareStatement(sql)) {
                        saveStmt.setString(1, question);
                        saveStmt.setString(2, correctAnswer);
                        saveStmt.setString(3, String.format("%.2f m/s", option1));
                        saveStmt.setString(4, String.format("%.2f m/s", option2));
                        saveStmt.setString(5, String.format("%.2f m/s", option3));
                        saveStmt.setString(6, correctAnswer);
                        saveStmt.setString(7, "A");
                        saveStmt.setInt(8, 0);
                        saveStmt.setInt(9, 0);
                        saveStmt.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("SQL error while inserting question: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("File has been created: " + filePath);
        } catch (IOException e) {
            System.err.println("File writing error: " + e.getMessage());
            e.printStackTrace();
        } 
}
private static void createQuestionsFile8(String filePath, Connection con) {
    final float GRAVITY = 9.8f; // acceleration
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float initial_velocity = 20.0f; initial_velocity <= 30.0f; initial_velocity += 1.0f) {
            for (float time = 3.0f; time <= 10.0f; time += 1.0f) {
                // Calculate final velocity using the formula v = u + at
                float final_velocity = initial_velocity - (GRAVITY * time); 
                float option1 = final_velocity + 1.0f;
                float option2 = final_velocity + 2.0f;
                float option3 = final_velocity - 1.0f;
                String question = String.format("A ball is thrown vertically upwards with an initial velocity of %.1f m/s. What is its velocity after %.1f seconds?", initial_velocity, time);
                String correctAnswer = String.format("%.2f m/s", final_velocity);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f m/s", option1);
                String answerC = "C) " + String.format("%.2f m/s", option2);
                String answerD = "D) " + String.format("%.2f m/s", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                String sql = "INSERT INTO Question8 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(sql)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, answerA); // Option1
                    saveStmt.setString(3, answerB); // Option2
                    saveStmt.setString(4, answerC); // Option3
                    saveStmt.setString(5, answerD); // Option4
                    saveStmt.setString(6, correctAnswer); // Answer
                    saveStmt.setString(7, "A"); // Correct answer position
                    saveStmt.setInt(8, 0); // TrainingUsed
                    saveStmt.setInt(9, 0); // ExamUsed
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile9(String filePath, Connection con) {
    final float GRAVITY = 9.8f; //acceleration
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float initial_velocity = 20.0f; initial_velocity <= 30.0f; initial_velocity += 1.0f) {
            for (float time = 3.0f; time <= 10.0f; time += 1.0f) {
                // Calculate the distance traveled using the formula s = ut + 0.5at^2
                float distance = (initial_velocity * time) + (0.5f * GRAVITY * time * time);
                float option1 = distance + 10.0f;
                float option2 = distance + 20.0f;
                float option3 = distance - 10.0f;
                String question = String.format("An object is thrown vertically upwards with an initial velocity of %.1f m/s. How far will it have traveled after %.1f seconds?", initial_velocity, time);
                String correctAnswer = String.format("%.2f meters", distance);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f meters", option1);
                String answerC = "C) " + String.format("%.2f meters", option2);
                String answerD = "D) " + String.format("%.2f meters", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                String sql = "INSERT INTO Question9 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(sql)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, answerA); // Option1
                    saveStmt.setString(3, answerB); // Option2
                    saveStmt.setString(4, answerC); // Option3
                    saveStmt.setString(5, answerD); // Option4
                    saveStmt.setString(6, correctAnswer); // Answer
                    saveStmt.setString(7, "A"); // Correct answer position
                    saveStmt.setInt(8, 0); // TrainingUsed
                    saveStmt.setInt(9, 0); // ExamUsed
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }

        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void  createQuestionsFile10(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float mass = 3.0f; mass <= 10.0f; mass++) {
            for (float velocity = 20.0f; velocity <= 30.0f; velocity++) {
                // Calculate  KE = 0.5 * m * v^2
                float kineticEnergy = 0.5f * mass * velocity * velocity;
                float option1 = kineticEnergy + 10.0f;
                float option2 = kineticEnergy + 20.0f;
                float option3 = kineticEnergy - 10.0f;
                String question = String.format("An object with a mass of %.1f kg is moving at a velocity of %.1f m/s. What is its kinetic energy?", mass, velocity);
                String correctAnswer = String.format("%.2f J", kineticEnergy);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f J", option1);
                String answerC = "C) " + String.format("%.2f J", option2);
                String answerD = "D) " + String.format("%.2f J", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                String sql = "INSERT INTO Question10 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(sql)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, answerA); // Option1
                    saveStmt.setString(3, answerB); // Option2
                    saveStmt.setString(4, answerC); // Option3
                    saveStmt.setString(5, answerD); // Option4
                    saveStmt.setString(6, correctAnswer); // Answer
                    saveStmt.setString(7, "A"); // Correct answer position
                    saveStmt.setInt(8, 0); // TrainingUsed
                    saveStmt.setInt(9, 0); // ExamUsed
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}

private static void  createQuestionsFile11(String filePath, Connection con) {
    final float GRAVITY = 9.8f; //  acceleration
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float mass = 3.0f; mass <= 10.0f; mass++) {
            for (float height = 5.0f; height <= 15.0f; height++) {
                // Calculate PE = mgh
                float potentialEnergy = mass * GRAVITY * height;
                float option1 = potentialEnergy + 10.0f;
                float option2 = potentialEnergy + 20.0f;
                float option3 = potentialEnergy - 10.0f;
                String question = String.format("An object with a mass of %.1f kg is raised to a height of %.1f meters. What is its potential energy?", mass, height);
                String correctAnswer = String.format("%.2f J", potentialEnergy);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f J", option1);
                String answerC = "C) " + String.format("%.2f J", option2);
                String answerD = "D) " + String.format("%.2f J", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                String sql = "INSERT INTO Question11 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(sql)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, answerA); // Option1
                    saveStmt.setString(3, answerB); // Option2
                    saveStmt.setString(4, answerC); // Option3
                    saveStmt.setString(5, answerD); // Option4
                    saveStmt.setString(6, correctAnswer); // Answer
                    saveStmt.setString(7, "A"); // Correct answer position
                    saveStmt.setInt(8, 0); // TrainingUsed
                    saveStmt.setInt(9, 0); // ExamUsed
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile12(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float force = 20.0f; force <= 30.0f; force += 1.0f) {
            for (float displacement = 5.0f; displacement <= 15.0f; displacement += 1.0f) {
                for (float angleDegrees = 0.0f; angleDegrees <= 90.0f; angleDegrees += 15.0f) {
                    float angleRadians = (float) Math.toRadians(angleDegrees);
                    // Calculate work  W = F * d * cos(theta)
                    float workDone = force * displacement * (float) Math.cos(angleRadians);
                    float option1 = workDone + 10.0f;
                    float option2 = workDone + 20.0f;
                    float option3 = workDone - 10.0f;
                    String question = String.format("A force of %.1f N is applied to move an object a distance of %.1f m at an angle of %.0f degrees. What is the work done?", force, displacement, angleDegrees);
                    String correctAnswer = String.format("%.2f J", workDone);
                    String answerA = "A) " + correctAnswer;
                    String answerB = "B) " + String.format("%.2f J", option1);
                    String answerC = "C) " + String.format("%.2f J", option2);
                    String answerD = "D) " + String.format("%.2f J", option3);
                    printWriter.println(question);
                    printWriter.println(answerA);
                    printWriter.println(answerB);
                    printWriter.println(answerC);
                    printWriter.println(answerD);
                    printWriter.println();
                    String sql = "INSERT INTO Question12 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    try (PreparedStatement saveStmt = con.prepareStatement(sql)) {
                        saveStmt.setString(1, question);
                        saveStmt.setString(2, answerA); // Option1
                        saveStmt.setString(3, answerB); // Option2
                        saveStmt.setString(4, answerC); // Option3
                        saveStmt.setString(5, answerD); // Option4
                        saveStmt.setString(6, correctAnswer); // Answer
                        saveStmt.setString(7, "A"); // Correct answer position
                        saveStmt.setInt(8, 0); // TrainingUsed
                        saveStmt.setInt(9, 0); // ExamUsed
                        saveStmt.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("SQL error while inserting question: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile13(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float mass = 3.0f; mass <= 10.0f; mass++) {
            for (float velocity = 5.0f; velocity <= 15.0f; velocity += 1.0f) {
                // Calculate momentum p = mv
                float momentum = mass * velocity;
                float option1 = momentum + 10.0f;
                float option2 = momentum + 20.0f;
                float option3 = momentum - 10.0f;
                String question = String.format("What is the momentum of an object with a mass of %.1f kg and a velocity of %.1f m/s?", mass, velocity);
                String correctAnswer = String.format("%.2f kg m/s", momentum);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f kg m/s", option1);
                String answerC = "C) " + String.format("%.2f kg m/s", option2);
                String answerD = "D) " + String.format("%.2f kg m/s", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                String statement = "INSERT INTO Question13 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f kg m/s", option1));
                    saveStmt.setString(4, String.format("%.2f kg m/s", option2));
                    saveStmt.setString(5, String.format("%.2f kg m/s", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile14(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float work = 200.0f; work <= 300.0f; work += 10.0f) {
            for (float time = 5.0f; time <= 15.0f; time += 1.0f) {
                // Calculate power P = W / t
                float power = work / time;
                float option1 = power + 10.0f;
                float option2 = power + 20.0f;
                float option3 = power - 10.0f;
                String question = String.format("What is the power required to do %.1f J of work in %.1f s?", work, time);
                String correctAnswer = String.format("%.2f W", power);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f W", option1);
                String answerC = "C) " + String.format("%.2f W", option2);
                String answerD = "D) " + String.format("%.2f W", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println(); 
                String statement = "INSERT INTO Question14 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f W", option1));
                    saveStmt.setString(4, String.format("%.2f W", option2));
                    saveStmt.setString(5, String.format("%.2f W", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile15(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float mass = 3.0f; mass <= 10.0f; mass++) {
            for (float velocity = 5.0f; velocity <= 15.0f; velocity += 1.0f) {
                // Calculate kinetic energy  KE = 0.5 * m * v^2
                float kineticEnergy = 0.5f * mass * velocity * velocity;
                float option1 = kineticEnergy + 10.0f;
                float option2 = kineticEnergy + 20.0f;
                float option3 = kineticEnergy - 10.0f;
                String question = String.format("What is the kinetic energy of an object with a mass of %.1f kg and a velocity of %.1f m/s?", mass, velocity);
                String correctAnswer = String.format("%.2f J", kineticEnergy);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f J", option1);
                String answerC = "C) " + String.format("%.2f J", option2);
                String answerD = "D) " + String.format("%.2f J", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println(); 
                String statement = "INSERT INTO Question15 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f J", option1));
                    saveStmt.setString(4, String.format("%.2f J", option2));
                    saveStmt.setString(5, String.format("%.2f J", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}

private static void createQuestionsFile16(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float mass = 50.0f; mass <= 100.0f; mass += 10.0f) {
            for (float volume = 5.0f; volume <= 15.0f; volume += 1.0f) {
                // Calculate density  = mass / volume
                float density = mass / volume;
                float option1 = density + 1.0f;
                float option2 = density + 2.0f;
                float option3 = density - 1.0f;
                String question = String.format("What is the density of an object with a mass of %.1f kg and a volume of %.1f m^3?", mass, volume);
                String correctAnswer = String.format("%.2f kg/m^3", density);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f kg/m^3", option1);
                String answerC = "C) " + String.format("%.2f kg/m^3", option2);
                String answerD = "D) " + String.format("%.2f kg/m^3", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                String statement = "INSERT INTO Question16 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f kg/m^3", option1));
                    saveStmt.setString(4, String.format("%.2f kg/m^3", option2));
                    saveStmt.setString(5, String.format("%.2f kg/m^3", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile17(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float force = 500.0f; force <= 1000.0f; force += 100.0f) {
            for (float area = 10.0f; area <= 20.0f; area += 2.0f) {
                // Calculate pressure = force / area
                float pressure = force / area;
                float option1 = pressure + 10.0f;
                float option2 = pressure + 20.0f;
                float option3 = pressure - 10.0f;
                String question = String.format("What is the pressure exerted by a force of %.1f N over an area of %.1f m^2?", force, area);
                String correctAnswer = String.format("%.2f Pa", pressure);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f Pa", option1);
                String answerC = "C) " + String.format("%.2f Pa", option2);
                String answerD = "D) " + String.format("%.2f Pa", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                String statement = "INSERT INTO Question17 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f Pa", option1));
                    saveStmt.setString(4, String.format("%.2f Pa", option2));
                    saveStmt.setString(5, String.format("%.2f Pa", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile18(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float force = 500.0f; force <= 1000.0f; force += 100.0f) {
            for (float distance = 10.0f; distance <= 20.0f; distance += 2.0f) {
                // Calculate work = force * distance
                float work = force * distance;
                float option1 = work + 1000.0f;
                float option2 = work + 2000.0f;
                float option3 = work - 1000.0f;
                String question = String.format("What is the work done by a force of %.1f N over a distance of %.1f m?", force, distance);
                String correctAnswer = String.format("%.2f J", work);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f J", option1);
                String answerC = "C) " + String.format("%.2f J", option2);
                String answerD = "D) " + String.format("%.2f J", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println(); 
                String statement = "INSERT INTO Question18 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f J", option1));
                    saveStmt.setString(4, String.format("%.2f J", option2));
                    saveStmt.setString(5, String.format("%.2f J", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile19(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float voltage = 50.0f; voltage <= 100.0f; voltage += 10.0f) {
            for (float resistance = 5.0f; resistance <= 15.0f; resistance += 1.0f) {
                // Calculate electric I = V / R
                float current = voltage / resistance;
                float option1 = current + 0.5f;
                float option2 = current + 1.0f;
                float option3 = current - 0.5f;
                String question = String.format("What is the electric current flowing through a resistor with a voltage of %.1f V and a resistance of %.1f ohms?", voltage, resistance);
                String correctAnswer = String.format("%.2f A", current);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f A", option1);
                String answerC = "C) " + String.format("%.2f A", option2);
                String answerD = "D) " + String.format("%.2f A", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                String statement = "INSERT INTO Question19 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f A", option1));
                    saveStmt.setString(4, String.format("%.2f A", option2));
                    saveStmt.setString(5, String.format("%.2f A", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }

}
     private static void createQuestionsFile20(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        for (float mass = 1.0f; mass <= 20.0f; mass += 1.0f) {
            for (float velocity = 10.0f; velocity <= 40.0f; velocity += 1.0f) {
                // Calculate kinetic energy = 0.5 * mass * velocity^2
                float kineticEnergy = 0.5f * mass * velocity * velocity;
                float option1 = kineticEnergy + 100.0f;
                float option2 = kineticEnergy + 200.0f;
                float option3 = kineticEnergy - 50.0f;
                String question = String.format("What is the kinetic energy of an object with mass %.1f kg moving at %.1f m/s?", mass, velocity);
                String correctAnswer = String.format("%.2f J", kineticEnergy);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f J", option1);
                String answerC = "C) " + String.format("%.2f J", option2);
                String answerD = "D) " + String.format("%.2f J", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println(); 
                String statement = "INSERT INTO Question20 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f J", option1));
                    saveStmt.setString(4, String.format("%.2f J", option2));
                    saveStmt.setString(5, String.format("%.2f J", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
  private static void createQuestionsFile21(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        float gravity = 9.8f;
        for (float mass = 1.0f; mass <= 20.0f; mass += 1.0f) {
            for (float height = 1.0f; height <= 10.0f; height += 1.0f) {
                // Calculate potential energy = mass * gravity * height
                float potentialEnergy = mass * gravity * height;
                float option1 = potentialEnergy + 100.0f;
                float option2 = potentialEnergy + 200.0f;
                float option3 = potentialEnergy - 50.0f;
                String question = String.format("What is the potential energy of an object with mass %.1f kg lifted to a height of %.1f m?", mass, height);
                String correctAnswer = String.format("%.2f J", potentialEnergy);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f J", option1);
                String answerC = "C) " + String.format("%.2f J", option2);
                String answerD = "D) " + String.format("%.2f J", option3);
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                String statement = "INSERT INTO Question21(Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f J", option1));
                    saveStmt.setString(4, String.format("%.2f J", option2));
                    saveStmt.setString(5, String.format("%.2f J", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}

private static void createQuestionsFile22(String filePath, Connection con) {
    float gravity = 9.8f;
    
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        
        for (float mass = 1.0f; mass <= 20.0f; mass += 1.0f) {
            for (float height = 1.0f; height <= 10.0f; height += 1.0f) {
                
                // Calculate potential energy = mass * gravity * height
                float potentialEnergy = mass * gravity * height;
                float option1 = potentialEnergy + 100.0f;
                float option2 = potentialEnergy + 200.0f;
                float option3 = potentialEnergy - 50.0f;
                
                String question = String.format("What is the potential energy of an object with mass %.1f kg lifted to a height of %.1f m?", mass, height);
                String correctAnswer = String.format("%.2f J", potentialEnergy);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f J", option1);
                String answerC = "C) " + String.format("%.2f J", option2);
                String answerD = "D) " + String.format("%.2f J", option3);
                
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                
                String statement = "INSERT INTO Question22 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f J", option1));
                    saveStmt.setString(4, String.format("%.2f J", option2));
                    saveStmt.setString(5, String.format("%.2f J", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
        
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile23(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        
        for (float force = 10.0f; force <= 100.0f; force += 10.0f) {
            for (float displacement = 1.0f; displacement <= 20.0f; displacement += 1.0f) {
                for (float angle = 0.0f; angle <= 90.0f; angle += 15.0f) {
                    
                    // Calculate work done = force * displacement * cos(angle)
                    double radians = Math.toRadians(angle);
                    float workDone = (float) (force * displacement * Math.cos(radians));
                    float option1 = workDone + 50.0f;
                    float option2 = workDone + 100.0f;
                    float option3 = workDone - 25.0f;
                    
                    String question = String.format("What is the work done by a force of %.1f N applied over a displacement of %.1f m at an angle of %.1f degrees?", force, displacement, angle);
                    String correctAnswer = String.format("%.2f J", workDone);
                    String answerA = "A) " + correctAnswer;
                    String answerB = "B) " + String.format("%.2f J", option1);
                    String answerC = "C) " + String.format("%.2f J", option2);
                    String answerD = "D) " + String.format("%.2f J", option3);
                    
                    printWriter.println(question);
                    printWriter.println(answerA);
                    printWriter.println(answerB);
                    printWriter.println(answerC);
                    printWriter.println(answerD);
                    printWriter.println();
                    
                    String statement = "INSERT INTO Question23 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                        saveStmt.setString(1, question);
                        saveStmt.setString(2, correctAnswer);
                        saveStmt.setString(3, String.format("%.2f J", option1));
                        saveStmt.setString(4, String.format("%.2f J", option2));
                        saveStmt.setString(5, String.format("%.2f J", option3));
                        saveStmt.setString(6, correctAnswer);
                        saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                        saveStmt.setInt(8, 0);
                        saveStmt.setInt(9, 0);
                        saveStmt.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("SQL error while inserting question: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("File has been created: " + filePath);
        
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile24(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        
        for (float force = 10.0f; force <= 100.0f; force += 10.0f) {
            for (float distance = 1.0f; distance <= 20.0f; distance += 1.0f) {
                for (float time = 1.0f; time <= 10.0f; time += 1.0f) {
                    
                    // Calculate power = (force * distance) / time
                    float power = (force * distance) / time;
                    float option1 = power + 10.0f;
                    float option2 = power + 20.0f;
                    float option3 = power - 5.0f;
                    
                    String question = String.format("What is the mechanical power exerted by a force of %.1f N over a distance of %.1f m in %.1f seconds?", force, distance, time);
                    String correctAnswer = String.format("%.2f W", power);
                    String answerA = "A) " + correctAnswer;
                    String answerB = "B) " + String.format("%.2f W", option1);
                    String answerC = "C) " + String.format("%.2f W", option2);
                    String answerD = "D) " + String.format("%.2f W", option3);
                    
                    printWriter.println(question);
                    printWriter.println(answerA);
                    printWriter.println(answerB);
                    printWriter.println(answerC);
                    printWriter.println(answerD);
                    printWriter.println();
                    
                    String statement = "INSERT INTO Question24 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                        saveStmt.setString(1, question);
                        saveStmt.setString(2, correctAnswer);
                        saveStmt.setString(3, String.format("%.2f W", option1));
                        saveStmt.setString(4, String.format("%.2f W", option2));
                        saveStmt.setString(5, String.format("%.2f W", option3));
                        saveStmt.setString(6, correctAnswer);
                        saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                        saveStmt.setInt(8, 0);
                        saveStmt.setInt(9, 0);
                        saveStmt.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("SQL error while inserting question: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("File has been created: " + filePath);
        
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile25(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        
        for (float waveSpeed = 300.0f; waveSpeed <= 500.0f; waveSpeed += 20.0f) {
            for (float wavelength = 0.5f; wavelength <= 10.0f; wavelength += 0.5f) {
                
                // Calculate frequency = wave speed / wavelength
                float frequency = waveSpeed / wavelength;
                float option1 = frequency + 10.0f;
                float option2 = frequency + 20.0f;
                float option3 = frequency - 5.0f;
                
                String question = String.format("What is the frequency of a wave with speed %.1f m/s and wavelength %.1f m?", waveSpeed, wavelength);
                String correctAnswer = String.format("%.2f Hz", frequency);
                String answerA = "A) " + correctAnswer;
                String answerB = "B) " + String.format("%.2f Hz", option1);
                String answerC = "C) " + String.format("%.2f Hz", option2);
                String answerD = "D) " + String.format("%.2f Hz", option3);
                
                printWriter.println(question);
                printWriter.println(answerA);
                printWriter.println(answerB);
                printWriter.println(answerC);
                printWriter.println(answerD);
                printWriter.println();
                
                String statement = "INSERT INTO Question25 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                
                try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                    saveStmt.setString(1, question);
                    saveStmt.setString(2, correctAnswer);
                    saveStmt.setString(3, String.format("%.2f Hz", option1));
                    saveStmt.setString(4, String.format("%.2f Hz", option2));
                    saveStmt.setString(5, String.format("%.2f Hz", option3));
                    saveStmt.setString(6, correctAnswer);
                    saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                    saveStmt.setInt(8, 0);
                    saveStmt.setInt(9, 0);
                    saveStmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("SQL error while inserting question: " + e.getMessage());
                    e.printStackTrace();
                }
            }
        }
        System.out.println("File has been created: " + filePath);
        
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}
private static void createQuestionsFile26(String filePath, Connection con) {
    try (FileWriter fileWriter = new FileWriter(filePath);
         PrintWriter printWriter = new PrintWriter(fileWriter)) {
        
        for (float mass = 1.0f; mass <= 10.0f; mass += 1.0f) {
            for (float velocity = 1.0f; velocity <= 10.0f; velocity += 1.0f) {
                for (float radius = 1.0f; radius <= 10.0f; radius += 1.0f) {
                    
                    // Calculate centripetal force = (mass * velocity^2) / radius
                    float centripetalForce = (mass * velocity * velocity) / radius;
                    float option1 = centripetalForce + 10.0f;
                    float option2 = centripetalForce + 20.0f;
                    float option3 = centripetalForce - 5.0f;
                    
                    String question = String.format("What is the centripetal force on an object with mass %.1f kg moving at a velocity of %.1f m/s in a circular path with radius %.1f m?", mass, velocity, radius);
                    String correctAnswer = String.format("%.2f N", centripetalForce);
                    String answerA = "A) " + correctAnswer;
                    String answerB = "B) " + String.format("%.2f N", option1);
                    String answerC = "C) " + String.format("%.2f N", option2);
                    String answerD = "D) " + String.format("%.2f N", option3);
                    
                    printWriter.println(question);
                    printWriter.println(answerA);
                    printWriter.println(answerB);
                    printWriter.println(answerC);
                    printWriter.println(answerD);
                    printWriter.println();
                    
                    String statement = "INSERT INTO Question26 (Question, Option1, Option2, Option3, Option4, Answer, OptionPos, TrainingUsed, ExamUsed) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    
                    try (PreparedStatement saveStmt = con.prepareStatement(statement)) {
                        saveStmt.setString(1, question);
                        saveStmt.setString(2, correctAnswer);
                        saveStmt.setString(3, String.format("%.2f N", option1));
                        saveStmt.setString(4, String.format("%.2f N", option2));
                        saveStmt.setString(5, String.format("%.2f N", option3));
                        saveStmt.setString(6, correctAnswer);
                        saveStmt.setString(7, "A"); // Assuming option A is always the correct answer
                        saveStmt.setInt(8, 0);
                        saveStmt.setInt(9, 0);
                        saveStmt.executeUpdate();
                    } catch (SQLException e) {
                        System.err.println("SQL error while inserting question: " + e.getMessage());
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println("File has been created: " + filePath);
        
    } catch (IOException e) {
        System.err.println("File writing error: " + e.getMessage());
        e.printStackTrace();
    }
}

    }