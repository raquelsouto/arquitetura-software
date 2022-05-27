package unifacisa.arq.software.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@RequiredArgsConstructor
@ToString
public class Task {

    private final long id;
    private final String task;
    private final boolean completed;

}
