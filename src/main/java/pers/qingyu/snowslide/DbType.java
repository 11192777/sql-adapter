package pers.qingyu.snowslide;

import pers.qingyu.snowslide.util.FnvHash;

public enum DbType {
    other           (1),
    oracle          (1 << 1),
    mysql           (1 << 2),
    oceanbase       (1 << 3),
    ali_oracle          (1 << 4),
    oceanbase_oracle       (1 << 5),
    ;

    public final long mask;
    public final long hashCode64;

    DbType(long mask) {
        this.mask = mask;
        this.hashCode64 = FnvHash.hashCode64(name());
    }

    public static long of(DbType... types) {
        long value = 0;

        for (DbType type : types) {
            value |= type.mask;
        }

        return value;
    }

    public static DbType of(String name) {
        if (name == null || name.isEmpty()) {
            return null;
        }

        try {
            return valueOf(name);
        } catch (Exception e) {
            return null;
        }
    }

}
