package OgInternal;

import java.util.Objects;

public class Trener {

      private String name;
      private String surname;
      private int age;
      private int id;

      public Trener(){
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

      public String getSurname() {
            return surname;
      }

      public void setSurname(String surname) {
            this.surname = surname;
      }

      public int getAge() {
            return age;
      }

      public void setAge(int age) {
            this.age = age;
      }

      @Override
      public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Trener trener = (Trener) o;
            return id == trener.id && age == trener.age && Objects.equals(name, trener.name) && Objects.equals(surname, trener.surname);
      }

      @Override
      public int hashCode() {
            return Objects.hash(id, name, surname, age);
      }

      @Override
      public String toString() {
            return "Trener{" +
                    "name='" + name + '\'' +
                    ", surname='" + surname + '\'' +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
      }
}
