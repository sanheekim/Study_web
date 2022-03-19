package hello.hellospring.repository;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import com.mysql.jdbc.ResultSet;

import hello.hellospring.domain.Member;

public class JdbcTemplateMemberRepository implements MemberRepository {

	private final JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcTemplateMemberRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Member save(Member member) {
		SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate);
		jdbcInsert.withTableName("member").usingGeneratedKeyColumns("id");
		
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("name", member.getName());
		
		Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterource(parameters));
		member.setId(key.longValue());
		return member;
	}
	
	@Override
	public Optional<Member> findById(Long id) {
		List<Member> result = jdbcTemplate.query(sql: " select * from member where id = ?", memberRowMapper(), id);
		return result.stream().findAny();
	}
	
	@Override
	public Optional<Member> findByName(String name) {
		List<Member> result = jdbcTemplate.query(sql:"select * from member where name = ?", memberRowMapper(), name);
		return result.stream().findAny();
	}
	
	@Override
	public List<Member> findAll(){
		return jdbcTemplate.query(sql:"select * from member", memberRowMapper());
	}
	
	private RowMapper<Member> memberRowMapper(){
		return (rs, rowNum) -> {
			Member member = new Member();
			member.setId(rs.getLong(columnLabel:"id"));
			member.setName(rs.getString(columnLabel:"name"));
			return member;
		};
	}
	
}
