package Entity;

    public class Subject {

        private int id;

        private String subject;

        private int hours;

        public Subject(int id, String subject, int hours) {
            this.id = id;
            this.subject = subject;
            this.hours = hours;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public int getHours() {
            return hours;
        }

        public void setHours(int hours) {
            this.hours = hours;
        }

        @Override
        public String toString() {
            return "Subject{" +
                    "id=" + id +
                    ", subject='" + subject + '\'' +
                    ", hours=" + hours +
                    '}';
        }
    }
