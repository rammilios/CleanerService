package ru.innopolis.stc13.repository.dao;

import ru.innopolis.stc13.repository.pojo.Client;

public interface ClientDao {
    public boolean addClient(Client client);

    public Client getClientById(Integer client_id);

    public boolean updateClientById(Client client);

    public boolean deleteClientById(Integer client_id);
}
