package unifacisa.arq.software.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

@Getter
@RequiredArgsConstructor
@ToString
public class Task implements Serializable {

    private final long id;
    private final String task;
    private final boolean completed;

}
