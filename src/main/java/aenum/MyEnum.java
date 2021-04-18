package aenum;

/**
 * @author linzy
 * @create 2021-03-02 22:11:16
 */
public enum MyEnum {

    RED{
        @Override
        public long test(long l) {
            return super.test(l);
        }
    },

    BLUE {
        @Override
        public long test(long l) {
            return super.test(l);
        }
    };

    public long test(long l) {
        return l;
    }
}
