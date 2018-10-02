package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.repository.pojo.Manager;

public interface ManagerDao {
    public boolean addManager(Manager manager);

    public Manager getManagerById(Integer manager_id);

    public boolean updateManagerById(Manager manager);

    public boolean deleteManagerById(Integer manager_id);
}
