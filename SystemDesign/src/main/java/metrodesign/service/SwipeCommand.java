package metrodesign.service;

@FunctionalInterface
public interface SwipeCommand {
    void execute() throws Exception;
}
