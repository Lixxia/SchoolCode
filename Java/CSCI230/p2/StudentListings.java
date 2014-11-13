package p2;

import javax.swing.JOptionPane;

/**
 *
 * @author Laura Barber
 */
public class StudentListings {      
        private String name;
        private String identification;
        private String gpa;
        
        //param
        public StudentListings(String name, String identification, String gpa) {
            this.name = name;
            this.identification = identification;
            this.gpa = gpa;
        }     
        //noparam
        public StudentListings() {}
        
    @Override
        //prints info of string
        public String toString() {
            return("Name:" + name +
                    "\nID Number: " + identification +
                    "\nGPA: " + gpa);
        }
        //creates deep copy
        public StudentListings deepCopy() {
            StudentListings clone = new StudentListings(name, identification, gpa);
            return clone;
        }
        //compares
        public int compareTo(String targetKey) {
            return(name.compareTo(targetKey));
        }
        //accepts input from user
        public void input() {
            name = JOptionPane.showInputDialog("Enter name ");
            identification = JOptionPane.showInputDialog("Enter ID number ");
            gpa = JOptionPane.showInputDialog("Enter gpa ");  
        } 
}
