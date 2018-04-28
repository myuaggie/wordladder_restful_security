package com.example.wordladder_hwk2_1;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UserDAO {
    @Autowired
    private HibernateTemplate hibernateTemplate;
    public UserInfo getActiveUser(String userName) {
        UserInfo activeUserInfo = new UserInfo();
        short enabled = 1;
        DetachedCriteria criteria=DetachedCriteria.forClass(UserInfo.class);
        criteria.add(Restrictions.eq("userName", userName));
        criteria.add(Restrictions.eq("enabled", enabled));
        List<?> list =hibernateTemplate.findByCriteria(criteria);
        //"FROM UserInfo WHERE userName=? and enabled=?",
            //    userName, enabled);
        if(!list.isEmpty()) {
            activeUserInfo = (UserInfo)list.get(0);
        }
        return activeUserInfo;
    }
}