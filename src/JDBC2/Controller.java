/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC2;

import dao.DepartamentoDAO;
import dao.EmpleadoDAO;
import dao.FamiliarDAO;
import dao.ProyectoDAO;
import factory.DAOFactory;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import objetosEmpresa.Departamento;
import objetosEmpresa.Empleado;
import objetosEmpresa.Familiar;
import objetosEmpresa.Proyecto;
import java.sql.Connection;

/**
 *
 * @author Brais
 */
public class Controller {

    /**
     * @param args the command line arguments
     */
    static List<Empleado> empleados;
    static List<Departamento> departamentos;
    static List<Familiar> familiares;
    static List<Proyecto> proyectos;
    static Empleado empleado;

    public static void main(String[] args) {

        Vista v = new Vista();
        v.showMessage("Cargando...");
        //Create factory
        DAOFactory mySQLFactory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        //Create dAO
        EmpleadoDAO empDAO = mySQLFactory.getEmpleadoDAO();
        DepartamentoDAO deptDAO = mySQLFactory.getDepartamentoDAO();
        FamiliarDAO familiarDAO = mySQLFactory.getFamiliarDAO();
        ProyectoDAO proyectoDAO = mySQLFactory.getProyectoDAO();

        int opcion;
        do {
            opcion = v.mostrarMenu();
            String output = new String();
            switch (opcion) {
                case 1:
                    Connection conn;
                    try {
                        conn = mySQLFactory.getConnection();
                        empleados = empDAO.getAll(conn);
                        for (int i = 0; i < empleados.size(); i++) {
                            output += empleados.get(i).toString();
                        }
                        mySQLFactory.releaseConnection(conn);
                    } catch (Exception ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                case 2:
                    try {
                    conn = mySQLFactory.getConnection();
                    departamentos = deptDAO.getAll(conn);
                    mySQLFactory.releaseConnection(conn);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                for (int i = 0; i < departamentos.size(); i++) {
                    output += departamentos.get(i).toString();
                }
                break;
                case 3:
                    try {
                    conn = mySQLFactory.getConnection();
                    familiares = familiarDAO.getAll(conn);
                    mySQLFactory.releaseConnection(conn);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                for (int i = 0; i < familiares.size(); i++) {
                    output += familiares.get(i).toString();
                }
                break;
                case 4:
                    try {
                    conn = mySQLFactory.getConnection();
                    proyectos = proyectoDAO.getAll(conn);
                    mySQLFactory.releaseConnection(conn);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                for (int i = 0; i < proyectos.size(); i++) {
                    output += proyectos.get(i).toString();

                }
                break;
                case 5:
                    String id;
                    opcion = v.showMessageInt("1.)Empno\n2.)Ename\n3.)Job ");
                    id = v.showMessageString("Introduce el dato");
                    try {
                        conn = mySQLFactory.getConnection();
                        switch (opcion) {
                            case 1:
                                empleados = empDAO.get(EmpleadoDAO.EMPNO, id, conn);
                                break;
                            case 2:
                                empleados = empDAO.get(EmpleadoDAO.ENAME, id, conn);
                                break;
                            case 3:
                                empleados = empDAO.get(EmpleadoDAO.JOB, id, conn);
                                break;
                            default:
                                break;
                        }
                        for (Empleado e : empleados) {
                            output += e.toString();
                        }
                        mySQLFactory.releaseConnection(conn);
                    } catch (NullPointerException npe) {
                        System.out.println(npe.getMessage());
                    } catch (Exception ex) {
                    }
                    break;

                case 6:

                    id = v.showMessageString("Introduce la fecha a usar para buscar: ");
                    try {
                        conn = mySQLFactory.getConnection();
                        empleados = empDAO.get(EmpleadoDAO.COMPARA_FECHA, id, conn);
                        for (Empleado e : empleados) {
                            output += e.toString();
                        }
                        mySQLFactory.releaseConnection(conn);
                    } catch (NullPointerException npe) {
                        System.out.println(npe.getMessage());
                    } catch (Exception ex) {
                    }
                    break;

                case 7:
                    try {
                    conn = mySQLFactory.getConnection();
                    familiares = familiarDAO.getAll(conn);
                    mySQLFactory.releaseConnection(conn);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                for (int i = 0; i < familiares.size(); i++) {
                    output += familiares.get(i).toString();
                }
                break;

                case 8:
                    id = v.showMessageString("Introduce el nombre del empleado:");
                    try {
                        conn = mySQLFactory.getConnection();
                        familiares = familiarDAO.get(FamiliarDAO.BUSCA_POR_EMPLEADO, id, conn);
                        for (Familiar f : familiares) {
                            output += f.toString();
                        }
                        mySQLFactory.releaseConnection(conn);
                    } catch (NullPointerException npe) {
                        System.out.println(npe.getMessage());
                    } catch (Exception ex) {
                    }
                    break;
                case 9:
                    id = v.showMessageString("Introduce el numero de departamento:");
                    id += ";";
                    id += v.showMessageString("Introduce el salario a comparar:");

                    try {
                        conn = mySQLFactory.getConnection();
                        empleados = empDAO.get(EmpleadoDAO.BUSCA_POR_DEPARTAMENTO_Y_SALARIO, id, conn);
                        for (Empleado f : empleados) {
                            output += f.toString();
                        }
                        mySQLFactory.releaseConnection(conn);
                    } catch (NullPointerException npe) {
                        System.out.println(npe.getMessage());
                    } catch (Exception ex) {
                    }

                    break;
                case 10:
                    try {
                    conn = mySQLFactory.getConnection();
                    empDAO.invertirMayusculas(conn);
                    mySQLFactory.releaseConnection(conn);
                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
                case 11:
                    try {
                    conn = mySQLFactory.getConnection();
                    empDAO.aumentarComisiones(conn);
                    mySQLFactory.releaseConnection(conn);

                } catch (Exception ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);

                }
                break;

                case 12:
                    try {
                    conn = mySQLFactory.getConnection();
                    empDAO.separarEmpleadosYJefes(conn);
                    mySQLFactory.releaseConnection(conn);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 13:
                    try {
                    conn = mySQLFactory.getConnection();
                    int numJefes = empDAO.mostrarNumeroDeJefes(conn);
                    if (numJefes != -1) {
                        output += "Hay " + numJefes + " jefes\n";
                    } else {
                        output += "error";
                    }
                    mySQLFactory.releaseConnection(conn);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 14:
                     try {
                    conn = mySQLFactory.getConnection();
                    id = v.showMessageString("Introduce el dato");
                    empleados = empDAO.buscarEmpleadoPorNumero(id, conn);
                    for (Empleado e : empleados) {
                        output += e.toString();
                    }
                    mySQLFactory.releaseConnection(conn);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
                break;
                case 15:
                    try {
                    conn = mySQLFactory.getConnection();
                    empDAO.insertarBatch(conn);
                    mySQLFactory.releaseConnection(conn);
                } catch (Exception ex) {

                }
                break;
                case 16:
                    try {
                    conn = mySQLFactory.getConnection();
                    familiarDAO.insertarBatch(conn);
                    mySQLFactory.releaseConnection(conn);
                } catch (Exception ex) {
                    
                }
                break;
                default:
                    break;
            }
            v.showMessage(output);
        } while (opcion != 0);
    }

}
