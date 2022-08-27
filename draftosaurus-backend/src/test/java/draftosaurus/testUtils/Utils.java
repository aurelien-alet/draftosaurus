package draftosaurus.testUtils;

import java.lang.reflect.Field;

public class Utils {
    
    public static <T, U> U getStaticFieldValueFromGenericClass(Class<T> genericClass, Class<U> fieldType){
        try {
            return tryToGetStaticFieldValueFromGenericClass(genericClass, fieldType);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    private static <T, U> U tryToGetStaticFieldValueFromGenericClass(
        Class<T> genericClass, Class<U> fieldType
    ) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
        Field field = genericClass.getDeclaredField("specy");
        Object fieldValue = field.get(fieldType);
        return (U) fieldValue;
    }

}
