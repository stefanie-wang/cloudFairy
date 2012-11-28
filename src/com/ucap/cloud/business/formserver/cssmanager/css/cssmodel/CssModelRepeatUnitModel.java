/**
 * <br>
 * CSS Modle<br>
 * @copy right ucap company All rights reserved.<br>
 * <br>
 * @Title: CssModelRepeatUnitModel.java
 * @Package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel
 */
package com.ucap.cloud.business.formserver.cssmanager.css.cssmodel;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.ucap.cloud.builder.model.ModelRoot;

/**
 * @ClassName CssModelRepeatUnitModel
 * @Description TODO 重复快模型
 * @author piaozg
 * @date 2012-8-10
 */
public class CssModelRepeatUnitModel implements ModelRoot{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@SuppressWarnings("unused")
	private Logger logger = Logger.getLogger(this.getClass());

	public CssModelRepeatUnitModel() {
	}
	/**
	 *  固定宽度
	 */
	private String fixHeight = "";
	/**
	 *  组ID
	 */
	private String groupId = "";
	/**
	 *  打印
	 */
	private String printable = "";
	/**
	 *  显示头
	 */
	private String showTitle = "";
	/**
	 *  头高度
	 */
	private String titleHeight = "";
	/**
	 *  描述
	 */
	private String describe = "";
	/**
	 *  是否隐藏
	 */
	private String hidden = "";
	/**
	 * 域宽度
	 */
	private String seqAreaWidth = "";
	/**
	 *  演示序号
	 */
	private String showSeq = "";
	/**
	 *  table索引
	 */
	private String tabIndex = "";
	/**
	 *  table头
	 */
	private String refHeader = "";
	/**
	 *  是否有效
	 */
	private String disable = "";
	/**
	 *  固定行数
	 */
	private String fixRowNum = "";
	/**
	 *  最大行数
	 */
	private String maxRowsCount = "";
	/**
	 *  是否可中断
	 */
	private String allowPageBreaks = "";
	/**
	 *  table头是否可复制
	 */
	private String allowHeaderRepeat = "";
	/**
	 *  删除空白行
	 */
	private String DelBlankLine = "";
	/**
	 *  行数
	 */
	private String rowNum = "";
	/**
	 * 名字
	 */
	private String name = "";
	/**
	 * 域集合
	 */
	private List<CssModelRepeatAreaModel> remodellist = new ArrayList<CssModelRepeatAreaModel>();
	/**
	 * title集合
	 */
	private List<CssModelRepeatTitleModel> titleList = new ArrayList<CssModelRepeatTitleModel>();
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<CssModelRepeatTitleModel> getTitleList() {
		return titleList;
	}

	public void setTitleList(List<CssModelRepeatTitleModel> titleList) {
		this.titleList = titleList;
	}

	public List<CssModelRepeatAreaModel> getRemodellist() {
		return remodellist;
	}

	public void setRemodellist(List<CssModelRepeatAreaModel> remodellist) {
		this.remodellist = remodellist;
	}

	private CssModelSizeAndPosition sizwand = new CssModelSizeAndPosition();

	public CssModelSizeAndPosition getSizwand() {
		return sizwand;
	}

	public void setSizwand(CssModelSizeAndPosition sizwand) {
		this.sizwand = sizwand;
	}

	public String getFixHeight() {
		return fixHeight;
	}

	public void setFixHeight(String fixHeight) {
		this.fixHeight = fixHeight;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getPrintable() {
		return printable;
	}

	public void setPrintable(String printable) {
		this.printable = printable;
	}

	public String getShowTitle() {
		return showTitle;
	}

	public void setShowTitle(String showTitle) {
		this.showTitle = showTitle;
	}

	public String getTitleHeight() {
		return titleHeight;
	}

	public void setTitleHeight(String titleHeight) {
		this.titleHeight = titleHeight;
	}

	public String getDescribe() {
		return describe;
	}

	public void setDescribe(String describe) {
		this.describe = describe;
	}

	public String getHidden() {
		return hidden;
	}

	public void setHidden(String hidden) {
		this.hidden = hidden;
	}

	public String getSeqAreaWidth() {
		return seqAreaWidth;
	}

	public void setSeqAreaWidth(String seqAreaWidth) {
		this.seqAreaWidth = seqAreaWidth;
	}

	public String getShowSeq() {
		return showSeq;
	}

	public void setShowSeq(String showSeq) {
		this.showSeq = showSeq;
	}

	public String getTabIndex() {
		return tabIndex;
	}

	public void setTabIndex(String tabIndex) {
		this.tabIndex = tabIndex;
	}

	public String getRefHeader() {
		return refHeader;
	}

	public void setRefHeader(String refHeader) {
		this.refHeader = refHeader;
	}

	public String getDisable() {
		return disable;
	}

	public void setDisable(String disable) {
		this.disable = disable;
	}

	public String getFixRowNum() {
		return fixRowNum;
	}

	public void setFixRowNum(String fixRowNum) {
		this.fixRowNum = fixRowNum;
	}

	public String getMaxRowsCount() {
		return maxRowsCount;
	}

	public void setMaxRowsCount(String maxRowsCount) {
		this.maxRowsCount = maxRowsCount;
	}

	public String getAllowPageBreaks() {
		return allowPageBreaks;
	}

	public void setAllowPageBreaks(String allowPageBreaks) {
		this.allowPageBreaks = allowPageBreaks;
	}

	public String getAllowHeaderRepeat() {
		return allowHeaderRepeat;
	}

	public void setAllowHeaderRepeat(String allowHeaderRepeat) {
		this.allowHeaderRepeat = allowHeaderRepeat;
	}

	public String getDelBlankLine() {
		return DelBlankLine;
	}

	public void setDelBlankLine(String delBlankLine) {
		DelBlankLine = delBlankLine;
	}

	public String getRowNum() {
		return rowNum;
	}

	public void setRowNum(String rowNum) {
		this.rowNum = rowNum;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((DelBlankLine == null) ? 0 : DelBlankLine.hashCode());
		result = prime
				* result
				+ ((allowHeaderRepeat == null) ? 0 : allowHeaderRepeat
						.hashCode());
		result = prime * result
				+ ((allowPageBreaks == null) ? 0 : allowPageBreaks.hashCode());
		result = prime * result
				+ ((describe == null) ? 0 : describe.hashCode());
		result = prime * result + ((disable == null) ? 0 : disable.hashCode());
		result = prime * result
				+ ((fixHeight == null) ? 0 : fixHeight.hashCode());
		result = prime * result
				+ ((fixRowNum == null) ? 0 : fixRowNum.hashCode());
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((hidden == null) ? 0 : hidden.hashCode());
		result = prime * result
				+ ((maxRowsCount == null) ? 0 : maxRowsCount.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((printable == null) ? 0 : printable.hashCode());
		result = prime * result
				+ ((refHeader == null) ? 0 : refHeader.hashCode());
		result = prime * result
				+ ((remodellist == null) ? 0 : remodellist.hashCode());
		result = prime * result + ((rowNum == null) ? 0 : rowNum.hashCode());
		result = prime * result
				+ ((seqAreaWidth == null) ? 0 : seqAreaWidth.hashCode());
		result = prime * result + ((showSeq == null) ? 0 : showSeq.hashCode());
		result = prime * result
				+ ((showTitle == null) ? 0 : showTitle.hashCode());
		result = prime * result + ((sizwand == null) ? 0 : sizwand.hashCode());
		result = prime * result
				+ ((tabIndex == null) ? 0 : tabIndex.hashCode());
		result = prime * result
				+ ((titleHeight == null) ? 0 : titleHeight.hashCode());
		result = prime * result
				+ ((titleList == null) ? 0 : titleList.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CssModelRepeatUnitModel other = (CssModelRepeatUnitModel) obj;
		if (DelBlankLine == null) {
			if (other.DelBlankLine != null)
				return false;
		} else if (!DelBlankLine.equals(other.DelBlankLine))
			return false;
		if (allowHeaderRepeat == null) {
			if (other.allowHeaderRepeat != null)
				return false;
		} else if (!allowHeaderRepeat.equals(other.allowHeaderRepeat))
			return false;
		if (allowPageBreaks == null) {
			if (other.allowPageBreaks != null)
				return false;
		} else if (!allowPageBreaks.equals(other.allowPageBreaks))
			return false;
		if (describe == null) {
			if (other.describe != null)
				return false;
		} else if (!describe.equals(other.describe))
			return false;
		if (disable == null) {
			if (other.disable != null)
				return false;
		} else if (!disable.equals(other.disable))
			return false;
		if (fixHeight == null) {
			if (other.fixHeight != null)
				return false;
		} else if (!fixHeight.equals(other.fixHeight))
			return false;
		if (fixRowNum == null) {
			if (other.fixRowNum != null)
				return false;
		} else if (!fixRowNum.equals(other.fixRowNum))
			return false;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (hidden == null) {
			if (other.hidden != null)
				return false;
		} else if (!hidden.equals(other.hidden))
			return false;
		if (maxRowsCount == null) {
			if (other.maxRowsCount != null)
				return false;
		} else if (!maxRowsCount.equals(other.maxRowsCount))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (printable == null) {
			if (other.printable != null)
				return false;
		} else if (!printable.equals(other.printable))
			return false;
		if (refHeader == null) {
			if (other.refHeader != null)
				return false;
		} else if (!refHeader.equals(other.refHeader))
			return false;
		if (remodellist == null) {
			if (other.remodellist != null)
				return false;
		} else if (!remodellist.equals(other.remodellist))
			return false;
		if (rowNum == null) {
			if (other.rowNum != null)
				return false;
		} else if (!rowNum.equals(other.rowNum))
			return false;
		if (seqAreaWidth == null) {
			if (other.seqAreaWidth != null)
				return false;
		} else if (!seqAreaWidth.equals(other.seqAreaWidth))
			return false;
		if (showSeq == null) {
			if (other.showSeq != null)
				return false;
		} else if (!showSeq.equals(other.showSeq))
			return false;
		if (showTitle == null) {
			if (other.showTitle != null)
				return false;
		} else if (!showTitle.equals(other.showTitle))
			return false;
		if (sizwand == null) {
			if (other.sizwand != null)
				return false;
		} else if (!sizwand.equals(other.sizwand))
			return false;
		if (tabIndex == null) {
			if (other.tabIndex != null)
				return false;
		} else if (!tabIndex.equals(other.tabIndex))
			return false;
		if (titleHeight == null) {
			if (other.titleHeight != null)
				return false;
		} else if (!titleHeight.equals(other.titleHeight))
			return false;
		if (titleList == null) {
			if (other.titleList != null)
				return false;
		} else if (!titleList.equals(other.titleList))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "CssModelRepeatUnitModel [DelBlankLine=" + DelBlankLine
				+ ", allowHeaderRepeat=" + allowHeaderRepeat
				+ ", allowPageBreaks=" + allowPageBreaks + ", describe="
				+ describe + ", disable=" + disable + ", fixHeight="
				+ fixHeight + ", fixRowNum=" + fixRowNum + ", groupId="
				+ groupId + ", hidden=" + hidden + ", maxRowsCount="
				+ maxRowsCount + ", name=" + name + ", printable=" + printable
				+ ", refHeader=" + refHeader + ", remodellist=" + remodellist
				+ ", rowNum=" + rowNum + ", seqAreaWidth=" + seqAreaWidth
				+ ", showSeq=" + showSeq + ", showTitle=" + showTitle
				+ ", sizwand=" + sizwand + ", tabIndex=" + tabIndex
				+ ", titleHeight=" + titleHeight + ", titleList=" + titleList
				+ "]";
	}
}
