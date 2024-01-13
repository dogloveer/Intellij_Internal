package OgInternal.model;

public enum FocusType {

      AEROBICS("aerobics"),
      BODYWEIGHT("bodyweight excercises"),
      CROSSFIT("crossfit"),
      STRETCHING("stretching"),
      WEIGHT("weight training"),
      UNKNOWN("Unknown");

      FocusType(String value){
            this.value =value;

      }
      public final String value;
}

