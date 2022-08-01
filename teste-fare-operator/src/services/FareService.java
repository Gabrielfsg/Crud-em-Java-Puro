package services;

import models.Fare;
import repository.FareRepository;

import java.util.List;

public class FareService {

    FareRepository fareRepository = new FareRepository();

    public void create(Fare fare)
    {
        fareRepository.insert(fare);
    }

    public void update(Fare fare)
    {
        fareRepository.update(fare);
    }

    public Fare getFareById(String fareId)
    {
        return fareRepository.getById(fareId);
    }

    public List<Fare> getFares()
    {
        return fareRepository.getAll();
    }
}
