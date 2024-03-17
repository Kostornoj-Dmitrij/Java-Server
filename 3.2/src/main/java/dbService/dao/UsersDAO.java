package dbService.dao;

import dbService.dataSets.UsersDataSet;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class UsersDAO {

    private Session session;

    public UsersDAO(Session session) {
        this.session = session;
    }

    public UsersDataSet get(long id) throws HibernateException {
        return (UsersDataSet) session.get(UsersDataSet.class, id);
    }

    public long getUserId(String login) throws HibernateException {
        Criteria criteria = session.createCriteria(UsersDataSet.class);
        UsersDataSet user = (UsersDataSet) criteria.add(Restrictions.eq("login", login)).uniqueResult();
        if (user == null) {
            return 0; // Возвращаем специальное значение, если пользователь не найден
        }
        return user.getId();
    }

    public long insertUser(String login, String password) throws HibernateException {
        return (Long) session.save(new UsersDataSet(login, password));
    }
}