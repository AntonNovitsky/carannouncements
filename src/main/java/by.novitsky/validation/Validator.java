package by.novitsky.validation;

public interface Validator<T>   {

    Boolean validate(T value);

}
