package Entity;

    public class Teacher {

        private int id;

        private String name;

        private int age;

        private String mainSubject;

        public Teacher(int id, String name, int age, String mainSubject) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.mainSubject = mainSubject;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getMainSubject() {
            return mainSubject;
        }

        public void setMainSubject(String mainSubject) {
            this.mainSubject = mainSubject;
        }

        @Override
        public String toString() {
            return "Teacher{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    ", mainSubject='" + mainSubject + '\'' +
                    '}';
        }
    }
