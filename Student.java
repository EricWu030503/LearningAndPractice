public class Student {
        private String name;
        private String ID;
        private String phone_number;
        private int age;
        private double grade;

        public Student(String name, String ID, String phone_number, int age, double grade){ // constructor
                this.name = name; // this in java means an object of the current class, and thus this.name refers to the private String name above and the second name refers to the input parameter
                this.ID = ID;
                this.phone_number = phone_number;
                this.age = age;
                this.grade = grade;
        }

        public Student(){ // this is a second constructor
                this("N/A","N/A","N/A",0,0); // we call the first constructor inside our second constructor
        }

        public void setName(String name){
                this.name = name;
        }

        public String getName(){
                return name;
        }

        public void setID(String id){
                ID = id;
        }

        public String getID(){
                return ID;
        }

        public void setPhone_number(String phone_number){
                this.phone_number = phone_number;
        }

        public String getPhone_number(){
                return phone_number;
        }

        public void setAge(int age){
                this.age = age;
        }

        public int getAge(){
                return age;
        }

        public void setGrade(double grade){
                this.grade = grade;
        }

        public double getGrade(){
                return grade;
        }

        public static void main(String[] args){
                Student student1 = new Student();
                System.out.println(student1.getAge());
                student1.setAge(18);
                System.out.println(student1.getAge());
                Student student2 = new Student("Eric","001","56061264",20,4.0);
                System.out.println(student2.getName());
        }

}
// It's a good habit to keep all variables in a class private and use getter and setter functions to access them whenever needed