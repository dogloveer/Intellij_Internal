package OgInternal.model;

public class GymView {

      public final String focusName;
      public final String trainerName;
      public final String trainerSurname;
      public final int focusTime;

      public GymView(String focusName, String trainerName, String trainerSurname, int focusTime) {
            this.focusName = focusName;
            this.trainerName = trainerName;
            this.trainerSurname = trainerSurname;
            this.focusTime = focusTime;
      }
}