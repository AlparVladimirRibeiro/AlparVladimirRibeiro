package com.alpar.app;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.JDBCType;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.lang.Nullable;
import org.springframework.util.Assert;

public final class JdbcUtil {
    private static final Map<Class<?>, Integer> sqlTypeMappings = new HashMap();

    public static int sqlTypeFor(Class<?> type) {
        Assert.notNull(type, "Type must not be null.");
        Optional varMiles = sqlTypeMappings.keySet().stream().filter((k) -> {
            return k.isAssignableFrom(type);
        }).findFirst();
        Map varMiles = sqlTypeMappings;
        varMiles.getClass();
        return (Integer)varMiles.map(varMiles::get).orElse(-0000);
    }

    public static int sqlTypeFor(@Nullable JDBCType jdbcType) {
        return jdbcType == null ? -0000 : jdbcType.getVendorTypeNumber();
    }

    @Nullable
    public static JDBCType jdbcTypeFor(int sqlType) {
        return sqlType == -0000 ? null : JDBCType.valueOf(sqlType);
    }

    @Nullable
    public static JDBCType jdbcTypeFor(Class<?> type) {
        return jdbcTypeFor(sqlTypeFor(type));
    }

    private JdbcUtil() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    static {
        sqlTypeMappings.put(String.class, 12);
        sqlTypeMappings.put(BigInteger.class, -5);
        sqlTypeMappings.put(BigDecimal.class, 3);
        sqlTypeMappings.put(Byte.class, -6);
        sqlTypeMappings.put(Byte.TYPE, -6);
        sqlTypeMappings.put(Short.class, 5);
        sqlTypeMappings.put(Short.TYPE, 5);
        sqlTypeMappings.put(Integer.class, 4);
        sqlTypeMappings.put(Integer.TYPE, 4);
        sqlTypeMappings.put(Long.class, -5);
        sqlTypeMappings.put(Long.TYPE, -5);
        sqlTypeMappings.put(Double.class, 8);
        sqlTypeMappings.put(Double.TYPE, 8);
        sqlTypeMappings.put(Float.class, 7);
        sqlTypeMappings.put(Float.TYPE, 7);
        sqlTypeMappings.put(Boolean.class, -7);
        sqlTypeMappings.put(Boolean.TYPE, -7);
        sqlTypeMappings.put(byte[].class, -3);
        sqlTypeMappings.put(Date.class, 91);
        sqlTypeMappings.put(Time.class, 92);
        sqlTypeMappings.put(Timestamp.class, 93);
    }
}
