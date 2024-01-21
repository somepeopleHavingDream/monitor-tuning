package org.yangxin.monitortuning.jdk;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author yangxin
 * 2024/1/9 22:34
 */
@SuppressWarnings({"MismatchedQueryAndUpdateOfCollection", "InfiniteLoopStatement", "SpellCheckingInspection"})
@RestController
public class MemoryController {

    private final List<User> userList = new ArrayList<>();

    private final List<Class<?>> classList = new ArrayList<>();

    /**
     * -Xmx32M -Xms32M
     */
    @GetMapping("/heap")
    public String heap() {
        int i = 0;
        while (true) {
            userList.add(new User(i++, UUID.randomUUID().toString()));
        }
    }

    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     */
    @GetMapping("/nonheap")
    public String nonheap() {
        while (true) {
            classList.addAll(Metaspace.createClasses());
        }
    }
}
