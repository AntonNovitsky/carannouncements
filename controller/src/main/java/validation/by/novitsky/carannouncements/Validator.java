package validation.by.novitsky.carannouncements;

public interface Validator<T>   {

    Boolean validate(T value);

}
