package func.lambda;

/**
 * @author linzy
 * @create 2021-04-21 9:56:08
 */
@FunctionalInterface
public interface Converter<F, T> {
    T convert(F from);
}
