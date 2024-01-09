package OgInternal;

public class Controller {

      private User user;
      private FocusType focusType;

      public Controller(User user) {
            this.user = user;
      }

      public static Controller empty() {
            return new Controller(new User());
      }

      public FocusType getFocusType() {
            return focusType;
      }

      public void setFocusType(FocusType focusType) {
            this.focusType = focusType;
      }
}