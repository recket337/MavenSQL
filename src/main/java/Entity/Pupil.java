package Entity;

    public class Pupil {

        private int id;

        private String fisrtName;

        private String lastName;

        private int avgMark;

        public Pupil(int id, String fisrtName, String lastName, int avgMark) {
            this.id = id;
            this.fisrtName = fisrtName;
            this.lastName = lastName;
            this.avgMark = avgMark;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFisrtName() {
            return fisrtName;
        }

        public void setFisrtName(String fisrtName) {
            this.fisrtName = fisrtName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public int getAvgMark() {
            return avgMark;
        }

        public void setAvgMark(int avgMark) {
            this.avgMark = avgMark;
        }

        @Override
        public String toString() {
            return "Pupil{" +
                    "id=" + id +
                    ", fisrtName='" + fisrtName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", avgMark=" + avgMark +
                    '}';
        }
    }
