package by.novitsky.carannouncements.validation;

public interface Validator<T>   {

    Boolean validate(T value);

}
