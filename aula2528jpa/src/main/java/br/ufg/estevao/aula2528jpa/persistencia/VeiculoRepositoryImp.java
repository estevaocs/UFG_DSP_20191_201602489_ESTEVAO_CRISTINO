package br.ufg.estevao.aula2528jpa.persistencia;

import br.ufg.estevao.aula2528jpa.model.Veiculo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class VeiculoRepositoryImp implements VeiculoRepository {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("br.ufg.estevao.aula2528jpa");
    private EntityManager em;

    public VeiculoRepositoryImp(){
        em = emf.createEntityManager();
    }

    @Override
    public Veiculo create(Veiculo veiculo) {
        em.getTransaction().begin();
        em.persist(veiculo);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public Veiculo read(Long id) {
        em.getTransaction().begin();
        Veiculo veiculo = em.find(Veiculo.class, id);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public List<Veiculo> findByMarca(String marca) {
        Query query = em.createQuery("Select p from Veiculo p where p.marca like :name");
        query.setParameter("name", marca);
        return query.getResultList();
    }

    @Override
    public List<Veiculo> findByModelo(String modelo) {
        Query query = em.createQuery("Select p from Veiculo p where p.modelo like :name");
        query.setParameter("name", modelo);
        return query.getResultList();
    }

    @Override
    public List<Veiculo> findByAnoFabricacao(Integer anoFabricacao) {
        Query query = em.createQuery("Select p from Veiculo p where p.anoFabricacao like :ano");
        query.setParameter("ano", anoFabricacao);
        return query.getResultList();
    }

    @Override
    public List<Veiculo> findByAnoModelo(Integer anoModelo) {
        Query query = em.createQuery("Select p from Veiculo p where p.anoModelo like :ano");
        query.setParameter("ano", anoModelo);
        return query.getResultList();
    }

    @Override
    public Veiculo update(Veiculo veiculo) {
        em.getTransaction().begin();
        veiculo = em.merge(veiculo);
        em.getTransaction().commit();
        return veiculo;
    }

    @Override
    public void delete(Veiculo veiculo) {
        em.getTransaction().begin();
        em.remove(veiculo);
        em.getTransaction().commit();
    }

    @Override
    public void close() {
        emf.close();
    }
}
