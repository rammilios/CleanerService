package ru.innopolis.stc13.repository.pojo;

public class Manager {
    private Integer manager_id;
    private String name;

    public Manager(Integer manager_id, String name) {
        this.manager_id = manager_id;
        this.name = name;
    }

    public Integer getManager_id() {
        return manager_id;
    }

    public void setManager_id(Integer manager_id) {
        this.manager_id = manager_id;
    }

    public String getManagerName() {
        return name;
    }

    public void setManagerName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "manager_id=" + manager_id +
                ", managerName='" + name + '\'' +
                '}';
    }
}
