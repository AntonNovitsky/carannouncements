package validation.by.novitsky.carannouncements;

public class IdValidator implements Validator<String> {
    @Override
    public Boolean validate(String value) {
        return value.matches("[0-9]+");
    }
}
