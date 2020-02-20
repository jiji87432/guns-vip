package cn.stylefeng.guns.modular.note.pojo;

import cn.stylefeng.guns.modular.note.entity.QxUser;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class QxNotifyUserPojo extends QxUser{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// 登陆日志ID
	private Long logonId;
}
