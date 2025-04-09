package cn.scifi.novelogic.infrastructure.common.serialize;

import cn.scifi.novelogic.infrastructure.common.constants.CodedEnum;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author bingdyee
 * @since 2024/9/10
 */
public class CodedEnumTypeHandler<E extends CodedEnum> extends BaseTypeHandler<E> {

    private final Class<E> type;
    private final E[] enums;

    public CodedEnumTypeHandler(Class<E> type) {
        if (type == null) {
            throw new IllegalArgumentException("Type <E extends CodedEnum> cannot be null.");
        }
        this.type = type;
        this.enums = type.getEnumConstants();
        if (enums == null) {
            throw new IllegalArgumentException("Unsupported Type <E extends CodedEnum>.");
        }
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        return CodedEnum.codeOf(this.type, code);
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        return CodedEnum.codeOf(this.type, code);
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        return CodedEnum.codeOf(this.type, code);
    }

}
