package com.digital.scripter.beans;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author Mohammad Aiub Khan
 * Created: 1/8/2024
 */
@Getter
@Setter
@ToString
public class FlagPair<S, T> {
    public FlagPair(S first, T second) {
        this.first = first;
        this.second = second;
    }

    private S first;
    private T second;
}
