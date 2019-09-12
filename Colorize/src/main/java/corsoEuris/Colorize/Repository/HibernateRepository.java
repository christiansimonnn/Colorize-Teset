package corsoEuris.Colorize.Repositories;

import com.ires.computers.models.Computer;
import com.ires.computers.viewmodels.ComputerNew;
import com.ires.computers.viewmodels.ComputerRow;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import static java.util.stream.Collectors.toList;
import java.util.stream.IntStream;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component(value="hibernate-repo")
public class HibernateRepository implements ColorizeRepository
{
    private final SessionFactory sessionFactory;
    public HibernateRepository() {
        sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Colorize.class)
                .buildSessionFactory();
    }

    @Override
    public List<ColorizeRow> getAll(String namePart) {
        try (var session = sessionFactory.openSession()) {
            var models = (List<Computer>)session
                    .createQuery("from Colors", Colorize.class)
                    .list();
            var viewModels = models.stream()
                    .map(ColorizeRow::map)
                    .collect(toList());
            return viewModels;
        }
    }

    @Override
    public Colorize get(int id) throws NotFoundException {
        try (var session = sessionFactory.openSession()) {
            var model = session.get(Colorize.class, id);
            if (model == null)
                throw new NotFoundException("Color not found!");
            return model;
        }
    }

    @Override
    public void post(ColorizeNew viewModel) {
        try (var session = sessionFactory.openSession()) {
            // If there is no autocommit property in the hibernate.cfg.xml,
            // We need to create manually the transactions...
            var trans = session.beginTransaction();
            var model = ComputerNew.map(viewModel);
            session.save(model);
            // ... and to commit them:
            trans.commit();
        }
    }

    @Override
    public void put(Computer viewModel) throws NotFoundException {
        try (var session = sessionFactory.openSession()) {
            var trans = session.beginTransaction();
            session.update(viewModel);
            trans.commit();
        }
    }

    @Override
    public void delete(int id) throws NotFoundException {
        try (var session = sessionFactory.openSession()) {
            var trans = session.beginTransaction();
            var model = session.get(Colorize.class, COLORS);
            session.delete(model);
            trans.commit();
        }
    }
}