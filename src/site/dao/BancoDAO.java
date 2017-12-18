package site.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.hibernate.Session;

import site.infra.HibernateUtil;
import site.modelos.Conteudo;
import site.modelos.DadosUsuario;

public class BancoDAO {
	private static Session session;

	public BancoDAO() {
		// h = new HibernateUtil();
		session = HibernateUtil.getSessionFactory().openSession();
		// this.session = CriadorDeSession.getSession();
	}

	public void fechaConexao() {
		session.close();
	}

	public static void inserir(Object object) {
		if (object instanceof DadosUsuario) {
			System.out.println("Inserindo no banco um DadosUsuario");
			DadosUsuario du = (DadosUsuario) object;
			session.beginTransaction();
			session.save(du);
			session.getTransaction().commit();
		} else {
			Conteudo ct = (Conteudo) object;
			session.beginTransaction();
			session.save(ct);
			session.getTransaction().commit();
		}

	}

	public List<Object> findAll(String tipo) {
		if (tipo.equals("DadosUsuario")) {
			return (session.createQuery("from site.modelos.DadosUsuario").list());
		} else {
			return (session.createQuery("from site.modelos.Conteudo").list());
		}
	}

	public Object findOne(int id, String tipo) {
		if (tipo.equals("DadosUsuario")) {
			DadosUsuario du = (DadosUsuario) session.load(DadosUsuario.class, id);
			return (Object) du;
		} else {
			Conteudo ct = (Conteudo) session.load(Conteudo.class, id);

			return (Object) ct;
		}

	}

	public static boolean remove(int id, String tipo) {
		boolean removeu = false;
		session.beginTransaction();
		
		if (tipo.equals("DadosUsuario")) {
			DadosUsuario du = (DadosUsuario) session.load(DadosUsuario.class, id);
			session.delete(du);
			removeu = true;
		} else {
			Conteudo ct = (Conteudo) session.load(Conteudo.class, id);
			session.delete(ct);
			removeu = true;
		}
		session.getTransaction().commit();
		return removeu;
	}

	public static void update(Object object) {
		boolean update = false;
		session.beginTransaction();
		if (object instanceof Conteudo) {
			Conteudo ct = (Conteudo) object;

			session.merge(ct);
		}
		session.getTransaction().commit();
		
	}

}