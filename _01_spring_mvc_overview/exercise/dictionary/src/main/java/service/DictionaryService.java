package service;

import repository.DictionaryRepository;
import repository.Repository;

public class DictionaryService implements Service {
    Repository repository = new DictionaryRepository();
    @Override
    public String findValue(String string) {
        return repository.findValue(string);
    }
}
