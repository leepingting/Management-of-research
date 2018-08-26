package srmsystem.service.impl;

import java.util.ArrayList;
import java.util.List;
import srmsystem.dao.AuditorDao;
import srmsystem.dao.PaperDao;
import srmsystem.dao.ProjectDao;
import srmsystem.dao.RoleScoreDao;
import srmsystem.dao.TeacherDao;
import srmsystem.dao.UserDao;
import srmsystem.domain.Paper;
import srmsystem.domain.Project;
import srmsystem.domain.RoleScore;
import srmsystem.domain.Teacher;
import srmsystem.domain.User;
import srmsystem.service.AudManager;
import srmsystem.vo.PaperBean;
import srmsystem.vo.ProjectBean;
import srmsystem.vo.TeacherBean;
//审核员实现类
public class AudManagerImpl implements AudManager{
    private AuditorDao audDao;
    private PaperDao paDao;
    private ProjectDao prDao;
    private RoleScoreDao rsDao;
    private TeacherDao teaDao;
    private UserDao userDao;
    	
	public AuditorDao getAudDao() {
		return audDao;
	}

	public void setAudDao(AuditorDao audDao) {
		this.audDao = audDao;
	}

	public PaperDao getPaDao() {
		return paDao;
	}

	public void setPaDao(PaperDao paDao) {
		this.paDao = paDao;
	}

	public ProjectDao getPrDao() {
		return prDao;
	}

	public void setPrDao(ProjectDao prDao) {
		this.prDao = prDao;
	}

	public RoleScoreDao getRsDao() {
		return rsDao;
	}

	public void setRsDao(RoleScoreDao rsDao) {
		this.rsDao = rsDao;
	}

	public TeacherDao getTeaDao() {
		return teaDao;
	}

	public void setTeaDao(TeacherDao teaDao) {
		this.teaDao = teaDao;
	}

	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public int validLogin(User user) {
		if(((userDao.findByUser(user)).size()>=1)&&(user.getRole()==1)){
			
			return LOGIN_AUD;
		}
		else if(((userDao.findByUser(user)).size()>=1)&&(user.getRole()==2)){
			return LOGIN_TEA;
		}
		else{
			return LOGIN_FAIL;		
		}		
	}
	
	@Override
	//获取全部论文信息
	public List<Paper> getAllPaper() {
		
		return paDao.findAll(Paper.class);
	}
	
	@Override
	//获取全部项目信息
	public List<Project> getAllProject() {
		
		return prDao.findAll(Project.class);
	}
	
	@Override
	/**
	 * @param paID论文编号
	 * @return 论文信息
	 */
	public List<PaperBean> getPaperBypaID(int paID) {		
		List<Paper> pa=paDao.findBypaIDList(paID);		
		List<PaperBean> result = new ArrayList<PaperBean>();
		// 封装VO集合
		for(Paper p: pa){
			result.add(new PaperBean(p.getPaID(),p.getPaName(),p.getPaLevel(),
					p.getPaScore(),p.getPaApplicant(),p.getPaStatus()));
		}
		return result;
	}
	
	@Override
	/**
	 * 
	 * @param prID项目编号
	 * @return 项目信息
	 */
	public List<ProjectBean> getProjectByprID(int prID) {
		List<Project> pr=prDao.findByprIDList(prID);
		List<ProjectBean> result=new ArrayList<ProjectBean>();
		// 封装VO集合
		for(Project p: pr){
			result.add(new ProjectBean(p.getPrID(),p.getPrName(),p.getPrLevel(),
					p.getPrFunding(),p.getPrScore(),p.getPrApplicant(),p.getPrStatus()));
		}
		return result;
	}

	@Override
	/**
	 * 
	 * @param TID教师编号
	 * @return 教师信息
	 */
	public List<TeacherBean> getTeaScore(String TID) {
		List<Teacher> tea=teaDao.findByTIDList(TID);
		List<TeacherBean> result=new ArrayList<TeacherBean>();
		for(Teacher t: tea){
			result.add(new TeacherBean(t.getTID(), t.getTName(), t.getTScore()));	
		}
		return result;
	}

	//
	@Override
	public void checkPaper(int paID,boolean result) {
		// TODO Auto-generated method stub
		Paper p=paDao.findBypaID(paID);
		if(result){
			p.setPaStatus(2);
			paDao.update(p);
		}else{
			p.setPaStatus(3);
			paDao.update(p);
		}
	}

	@Override
	public void checkProject(int prID,boolean result) {
		// TODO Auto-generated method stub
		Project p=prDao.findByprID(prID);
		if(result){
			p.setPrStatus(2);
			prDao.update(p);
		}else{
			p.setPrStatus(3);
			prDao.update(p);
		}
	}

	@Override
	public void changeScore() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String findAName(String UID) {
		// TODO Auto-generated method stub
		String name=audDao.findByAID(UID).getAName();
		return name;
	}

	@Override
	public String findTName(String UID) {
		// TODO Auto-generated method stub
		String name=teaDao.findByTID(UID).getTName();
		return name;
	}

	@Override
	public List<PaperBean> findPaperbytea(String TID) {
		// TODO Auto-generated method stub
		Teacher t=teaDao.findByTID(TID);
		List<RoleScore> roleScore=rsDao.findByTeacher(t);
		List<PaperBean> result=new ArrayList<PaperBean>();
		for(RoleScore rs:roleScore){
			List<Paper> paper=new ArrayList<>();
			paper.addAll(rs.getPaper());
			for(Paper p:paper){
				PaperBean pb=new PaperBean(p.getPaID(),p.getPaName(),p.getPaLevel(),
						p.getPaScore(),p.getPaApplicant(),p.getPaStatus());
				pb.getRoleScore().add(rs);
				result.add(pb);
			}
		}
		return result;
	}

	@Override
	public List<ProjectBean> findProjectbytea(String TID) {
		// TODO Auto-generated method stub
		Teacher t=teaDao.findByTID(TID);
		List<RoleScore> roleScore=rsDao.findByTeacher(t);
		List<ProjectBean> result=new ArrayList<ProjectBean>();
		for(RoleScore rs:roleScore){
			List<Project> project=new ArrayList<>();
			project.addAll(rs.getProject());
			for(Project p:project){
				ProjectBean pb=new ProjectBean(p.getPrID(),p.getPrName(),p.getPrLevel(),p.getPrFunding(),
						p.getPrScore(),p.getPrApplicant(),p.getPrStatus());
				pb.getRoleScore().add(rs);
				result.add(pb);
			}
		}
		return result;
	}

	@Override
	public String findTID(String UID) {
		// TODO Auto-generated method stub
		String TID=teaDao.findByName(UID).getTID();
		return TID;
	}

	@Override
	public List<PaperBean> findPaper(String paName) {
		// TODO Auto-generated method stub
		List<Paper> paper=paDao.findBypaName(paName);
		List<PaperBean> result=new ArrayList<PaperBean>();
		for(Paper p:paper){
			PaperBean pb=new PaperBean(p.getPaID(),p.getPaName(),p.getPaLevel(),
					p.getPaScore(),p.getPaApplicant(),p.getPaStatus());
			List<RoleScore> rs=new ArrayList<>();
			rs.addAll(p.getRoleScore());
			pb.setRoleScore(rs);
			result.add(pb);
		}
		return result;
	}

	@Override
	public List<ProjectBean> findProject(String prName) {
		// TODO Auto-generated method stub
		List<Project> project=prDao.findByprName(prName);
		List<ProjectBean> result=new ArrayList<ProjectBean>();
		for(Project p:project){
			ProjectBean pb=new ProjectBean(p.getPrID(),p.getPrName(),p.getPrLevel(),p.getPrFunding(),
					p.getPrScore(),p.getPrApplicant(),p.getPrStatus());
			List<RoleScore> rs=new ArrayList<>();
			rs.addAll(p.getRoleScore());
			pb.setRoleScore(rs);
			result.add(pb);
		}
		return result;
	}

	@Override
	public List<PaperBean> findbypaStatus(int paStatus) {
		// TODO Auto-generated method stub
		List<Paper> paper=paDao.findBypaStatus(paStatus);
		List<PaperBean> result=new ArrayList<PaperBean>();
		for(Paper p:paper){
			PaperBean pb=new PaperBean(p.getPaID(),p.getPaName(),p.getPaLevel(),
					p.getPaScore(),p.getPaApplicant(),p.getPaStatus());
			List<RoleScore> rs=new ArrayList<>();
			rs.addAll(p.getRoleScore());
			pb.setRoleScore(rs);
			result.add(pb);
		}
		return result;
	}

	@Override
	public List<ProjectBean> findbyprStatus(int prStatus) {
		// TODO Auto-generated method stub
		List<Project> project=prDao.findByprStatus(prStatus);
		List<ProjectBean> result=new ArrayList<ProjectBean>();
		for(Project p:project){
			ProjectBean pb=new ProjectBean(p.getPrID(),p.getPrName(),p.getPrLevel(),p.getPrFunding(),
					p.getPrScore(),p.getPrApplicant(),p.getPrStatus());
			List<RoleScore> rs=new ArrayList<>();
			rs.addAll(p.getRoleScore());
			pb.setRoleScore(rs);
			result.add(pb);
		}
		return result;
	}

	@Override
	public List<TeacherBean> sumTScore() {
		// TODO Auto-generated method stub
		List<Teacher> teacher=teaDao.find();
		List<TeacherBean> result=new ArrayList<TeacherBean>();
		for(Teacher t:teacher){
			double sum=0;
			List<RoleScore> roleScore=rsDao.findByTeacher(t);
			for(RoleScore rs:roleScore){
				List<Paper> paper=new ArrayList<>();
				paper.addAll(rs.getPaper());
				for(Paper pa:paper){
					if(pa.getPaStatus()==2){
						sum+=rs.getScore();
					}
				}
				List<Project> project=new ArrayList<>();
				project.addAll(rs.getProject());
				for(Project pr:project){
					if(pr.getPrStatus()==2){
						sum+=rs.getScore();
					}
				}
				t.setTScore(sum);
			}
			TeacherBean tb=new TeacherBean(t.getTID(),t.getTName(),t.getTScore());
			result.add(tb);
		}		
		return result;
	}
	
}
