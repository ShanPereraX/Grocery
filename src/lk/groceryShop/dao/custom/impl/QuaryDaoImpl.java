package lk.groceryShop.dao.custom.impl;

import lk.groceryShop.dao.custom.QuaryDao;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;

@NoArgsConstructor

public class QuaryDaoImpl implements QuaryDao {
    Session session;

    public QuaryDaoImpl(Session session) {
        this.session = session;
    }
}
