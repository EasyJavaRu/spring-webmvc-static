package ru.easyjava.spring.webmvc.sttc.service;

import org.springframework.stereotype.Service;
import ru.easyjava.spring.webmvc.sttc.entity.Package;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PackageService {
    static Map<Integer, Package> warehouse = new LinkedHashMap<>();

    static {
        warehouse.put(1, new Package(1, "John Dow", 3));
        warehouse.put(2, new Package(2, "Jane Dow", 7));
        warehouse.put(3, new Package(3, "Douglas Adams", 42));
    }

    public Collection<Package> list() {
        synchronized (this) {
            return warehouse.values();
        }
    }

    public Package get(Integer id) {
        synchronized (this) {
            return warehouse.get(id);
        }
    }

    public void update(Package p) {
        synchronized (this) {
            warehouse.put(p.getId(), p);
        }
    }
 }
