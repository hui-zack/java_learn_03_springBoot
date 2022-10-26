package com.hui.domain.actionSql;

import com.hui.domain.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@Data
@ToString
public class ActionUser extends User {
    private Long minMoney;
    private Long maxMoney;
}
