import com.juego7th.Utils.HibernateUtil;
import com.juego7th.modelo.Users;
import org.hibernate.Session;
import org.hibernate.Transaction;

public
class Main {


    public static void main(String[] args) {


                // Crear un usuario de prueba
                Users nuevoUsuario = new Users("Ana", "ana@example.com", "contrasena123");

                // Abrir sesión Hibernate
                Session session = HibernateUtil.getSessionFactory().openSession();
                Transaction tx = null;

                try {
                    tx = session.beginTransaction();              // Iniciar transacción
                    session.save(nuevoUsuario);                   // Guardar el objeto
                    tx.commit();                                  // Confirmar cambios
                    System.out.println("✅ Usuario guardado correctamente.");
                } catch (Exception e) {
                    if (tx != null) tx.rollback();               // Revertir si falla
                    System.err.println("❌ Error al guardar: " + e.getMessage());
                } finally {
                    session.close();                             // Cerrar sesión
                }
            }
        }







