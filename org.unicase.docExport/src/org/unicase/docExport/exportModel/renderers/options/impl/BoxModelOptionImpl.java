/**
 * <copyright> Copyright (c) 2015-2016 Chair of Applied Software Engineering, Technische Universität München (TUM).
 * All rights reserved. This program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html </copyright>
 */
package org.unicase.docExport.exportModel.renderers.options.impl;

import java.awt.Color;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.unicase.docExport.exportModel.renderers.options.BoxModelOption;
import org.unicase.docExport.exportModel.renderers.options.OptionsFactory;
import org.unicase.docExport.exportModel.renderers.options.OptionsPackage;
import org.unicase.docExport.exportModel.renderers.options.UBorderStyle;
import org.unicase.docExport.exportModel.renderers.options.UColor;

/**
 * <!-- begin-user-doc --> An implementation of the model object '<em><b>Box Model Option</b></em>'. <!-- end-user-doc
 * -->
 * <p>
 * The following features are implemented:
 * <ul>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getMargin <em>Margin</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getMarginTop <em>Margin Top
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getMarginLeft <em>Margin Left
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getMarginBottom <em>Margin
 * Bottom</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getMarginRight <em>Margin
 * Right</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getBorder <em>Border</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getBorderTop <em>Border Top
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getBorderLeft <em>Border Left
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getBorderBottom <em>Border
 * Bottom</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getBorderRight <em>Border
 * Right</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getBorderStyle <em>Border
 * Style</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getBorderColor <em>Border
 * Color</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getPadding <em>Padding</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getPaddingTop <em>Padding Top
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getPaddingLeft <em>Padding
 * Left</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getPaddingBottom <em>Padding
 * Bottom</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getPaddingRight <em>Padding
 * Right</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getBackgroundColor <em>
 * Background Color</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#isKeepTogether <em>Keep
 * Together</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#isKeepWithPrevious <em>Keep
 * With Previous</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#isKeepWithNext <em>Keep With
 * Next</em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#isBreakBefore <em>Break Before
 * </em>}</li>
 * <li>{@link org.unicase.docExport.exportModel.renderers.options.impl.BoxModelOptionImpl#getWidth <em>Width</em>}</li>
 * </ul>
 * </p>
 * 
 * @generated
 */
public class BoxModelOptionImpl extends RendererOptionImpl implements BoxModelOption {
	/**
	 * The default value of the '{@link #getMargin() <em>Margin</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMargin()
	 * @generated
	 * @ordered
	 */
	protected static final double MARGIN_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMargin() <em>Margin</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMargin()
	 * @generated
	 * @ordered
	 */
	protected double margin = MARGIN_EDEFAULT;

	/**
	 * The default value of the '{@link #getMarginTop() <em>Margin Top</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMarginTop()
	 * @generated
	 * @ordered
	 */
	protected static final double MARGIN_TOP_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMarginTop() <em>Margin Top</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMarginTop()
	 * @generated
	 * @ordered
	 */
	protected double marginTop = MARGIN_TOP_EDEFAULT;

	/**
	 * The default value of the '{@link #getMarginLeft() <em>Margin Left</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMarginLeft()
	 * @generated
	 * @ordered
	 */
	protected static final double MARGIN_LEFT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMarginLeft() <em>Margin Left</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMarginLeft()
	 * @generated
	 * @ordered
	 */
	protected double marginLeft = MARGIN_LEFT_EDEFAULT;

	/**
	 * The default value of the '{@link #getMarginBottom() <em>Margin Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarginBottom()
	 * @generated
	 * @ordered
	 */
	protected static final double MARGIN_BOTTOM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMarginBottom() <em>Margin Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarginBottom()
	 * @generated
	 * @ordered
	 */
	protected double marginBottom = MARGIN_BOTTOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getMarginRight() <em>Margin Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMarginRight()
	 * @generated
	 * @ordered
	 */
	protected static final double MARGIN_RIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getMarginRight() <em>Margin Right</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getMarginRight()
	 * @generated
	 * @ordered
	 */
	protected double marginRight = MARGIN_RIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorder() <em>Border</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBorder()
	 * @generated
	 * @ordered
	 */
	protected static final double BORDER_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBorder() <em>Border</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBorder()
	 * @generated
	 * @ordered
	 */
	protected double border = BORDER_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderTop() <em>Border Top</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBorderTop()
	 * @generated
	 * @ordered
	 */
	protected static final double BORDER_TOP_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBorderTop() <em>Border Top</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBorderTop()
	 * @generated
	 * @ordered
	 */
	protected double borderTop = BORDER_TOP_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderLeft() <em>Border Left</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBorderLeft()
	 * @generated
	 * @ordered
	 */
	protected static final double BORDER_LEFT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBorderLeft() <em>Border Left</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBorderLeft()
	 * @generated
	 * @ordered
	 */
	protected double borderLeft = BORDER_LEFT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderBottom() <em>Border Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderBottom()
	 * @generated
	 * @ordered
	 */
	protected static final double BORDER_BOTTOM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBorderBottom() <em>Border Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderBottom()
	 * @generated
	 * @ordered
	 */
	protected double borderBottom = BORDER_BOTTOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderRight() <em>Border Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBorderRight()
	 * @generated
	 * @ordered
	 */
	protected static final double BORDER_RIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getBorderRight() <em>Border Right</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBorderRight()
	 * @generated
	 * @ordered
	 */
	protected double borderRight = BORDER_RIGHT_EDEFAULT;

	/**
	 * The default value of the '{@link #getBorderStyle() <em>Border Style</em>}' attribute. <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * 
	 * @see #getBorderStyle()
	 * @generated NOT
	 * @ordered
	 */
	protected static final UBorderStyle BORDER_STYLE_EDEFAULT = UBorderStyle.HIDDEN;

	/**
	 * The cached value of the '{@link #getBorderStyle() <em>Border Style</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getBorderStyle()
	 * @generated
	 * @ordered
	 */
	protected UBorderStyle borderStyle = BORDER_STYLE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBorderColor() <em>Border Color</em>}' containment reference. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getBorderColor()
	 * @generated
	 * @ordered
	 */
	protected UColor borderColor;

	/**
	 * The default value of the '{@link #getPadding() <em>Padding</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPadding()
	 * @generated
	 * @ordered
	 */
	protected static final double PADDING_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPadding() <em>Padding</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPadding()
	 * @generated
	 * @ordered
	 */
	protected double padding = PADDING_EDEFAULT;

	/**
	 * The default value of the '{@link #getPaddingTop() <em>Padding Top</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPaddingTop()
	 * @generated
	 * @ordered
	 */
	protected static final double PADDING_TOP_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPaddingTop() <em>Padding Top</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPaddingTop()
	 * @generated
	 * @ordered
	 */
	protected double paddingTop = PADDING_TOP_EDEFAULT;

	/**
	 * The default value of the '{@link #getPaddingLeft() <em>Padding Left</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaddingLeft()
	 * @generated
	 * @ordered
	 */
	protected static final double PADDING_LEFT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPaddingLeft() <em>Padding Left</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getPaddingLeft()
	 * @generated
	 * @ordered
	 */
	protected double paddingLeft = PADDING_LEFT_EDEFAULT;

	/**
	 * The default value of the '{@link #getPaddingBottom() <em>Padding Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaddingBottom()
	 * @generated
	 * @ordered
	 */
	protected static final double PADDING_BOTTOM_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPaddingBottom() <em>Padding Bottom</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaddingBottom()
	 * @generated
	 * @ordered
	 */
	protected double paddingBottom = PADDING_BOTTOM_EDEFAULT;

	/**
	 * The default value of the '{@link #getPaddingRight() <em>Padding Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaddingRight()
	 * @generated
	 * @ordered
	 */
	protected static final double PADDING_RIGHT_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getPaddingRight() <em>Padding Right</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPaddingRight()
	 * @generated
	 * @ordered
	 */
	protected double paddingRight = PADDING_RIGHT_EDEFAULT;

	/**
	 * The cached value of the '{@link #getBackgroundColor() <em>Background Color</em>}' reference.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @see #getBackgroundColor()
	 * @generated
	 * @ordered
	 */
	protected UColor backgroundColor;

	/**
	 * The default value of the '{@link #isKeepTogether() <em>Keep Together</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeepTogether()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEEP_TOGETHER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isKeepTogether() <em>Keep Together</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeepTogether()
	 * @generated
	 * @ordered
	 */
	protected boolean keepTogether = KEEP_TOGETHER_EDEFAULT;

	/**
	 * The default value of the '{@link #isKeepWithPrevious() <em>Keep With Previous</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isKeepWithPrevious()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEEP_WITH_PREVIOUS_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isKeepWithPrevious() <em>Keep With Previous</em>}' attribute. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #isKeepWithPrevious()
	 * @generated
	 * @ordered
	 */
	protected boolean keepWithPrevious = KEEP_WITH_PREVIOUS_EDEFAULT;

	/**
	 * The default value of the '{@link #isKeepWithNext() <em>Keep With Next</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeepWithNext()
	 * @generated
	 * @ordered
	 */
	protected static final boolean KEEP_WITH_NEXT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isKeepWithNext() <em>Keep With Next</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isKeepWithNext()
	 * @generated
	 * @ordered
	 */
	protected boolean keepWithNext = KEEP_WITH_NEXT_EDEFAULT;

	/**
	 * The default value of the '{@link #isBreakBefore() <em>Break Before</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isBreakBefore()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BREAK_BEFORE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBreakBefore() <em>Break Before</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isBreakBefore()
	 * @generated
	 * @ordered
	 */
	protected boolean breakBefore = BREAK_BEFORE_EDEFAULT;

	/**
	 * The default value of the '{@link #getWidth() <em>Width</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected static final int WIDTH_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getWidth() <em>Width</em>}' attribute. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @see #getWidth()
	 * @generated
	 * @ordered
	 */
	protected int width = WIDTH_EDEFAULT;

	/**
	 * The default value of the '{@link #isBreakAfter() <em>Break After</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isBreakAfter()
	 * @generated
	 * @ordered
	 */
	protected static final boolean BREAK_AFTER_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isBreakAfter() <em>Break After</em>}' attribute.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @see #isBreakAfter()
	 * @generated
	 * @ordered
	 */
	protected boolean breakAfter = BREAK_AFTER_EDEFAULT;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	protected BoxModelOptionImpl() {
		super();
		this.setBorderColor(OptionsFactory.eINSTANCE.createUColor());
	}

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return OptionsPackage.Literals.BOX_MODEL_OPTION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getMargin() {
		return margin;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMargin(double newMargin) {
		double oldMargin = margin;
		margin = newMargin;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__MARGIN, oldMargin, margin));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getMarginTop() {
		return marginTop;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarginTop(double newMarginTop) {
		double oldMarginTop = marginTop;
		marginTop = newMarginTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__MARGIN_TOP, oldMarginTop, marginTop));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getMarginLeft() {
		return marginLeft;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarginLeft(double newMarginLeft) {
		double oldMarginLeft = marginLeft;
		marginLeft = newMarginLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__MARGIN_LEFT, oldMarginLeft, marginLeft));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getMarginBottom() {
		return marginBottom;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarginBottom(double newMarginBottom) {
		double oldMarginBottom = marginBottom;
		marginBottom = newMarginBottom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__MARGIN_BOTTOM, oldMarginBottom, marginBottom));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getMarginRight() {
		return marginRight;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setMarginRight(double newMarginRight) {
		double oldMarginRight = marginRight;
		marginRight = newMarginRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__MARGIN_RIGHT, oldMarginRight, marginRight));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getBorder() {
		return border;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorder(double newBorder) {
		double oldBorder = border;
		border = newBorder;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BORDER, oldBorder, border));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getBorderTop() {
		return borderTop;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderTop(double newBorderTop) {
		double oldBorderTop = borderTop;
		borderTop = newBorderTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BORDER_TOP, oldBorderTop, borderTop));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getBorderLeft() {
		return borderLeft;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderLeft(double newBorderLeft) {
		double oldBorderLeft = borderLeft;
		borderLeft = newBorderLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BORDER_LEFT, oldBorderLeft, borderLeft));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getBorderBottom() {
		return borderBottom;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderBottom(double newBorderBottom) {
		double oldBorderBottom = borderBottom;
		borderBottom = newBorderBottom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BORDER_BOTTOM, oldBorderBottom, borderBottom));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getBorderRight() {
		return borderRight;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderRight(double newBorderRight) {
		double oldBorderRight = borderRight;
		borderRight = newBorderRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BORDER_RIGHT, oldBorderRight, borderRight));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UBorderStyle getBorderStyle() {
		return borderStyle;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderStyle(UBorderStyle newBorderStyle) {
		UBorderStyle oldBorderStyle = borderStyle;
		borderStyle = newBorderStyle == null ? BORDER_STYLE_EDEFAULT : newBorderStyle;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BORDER_STYLE, oldBorderStyle, borderStyle));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UColor getBorderColor() {
		return borderColor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBorderColor(UColor newBorderColor, NotificationChain msgs) {
		UColor oldBorderColor = borderColor;
		borderColor = newBorderColor;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR, oldBorderColor, newBorderColor);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBorderColor(UColor newBorderColor) {
		if (newBorderColor != borderColor) {
			NotificationChain msgs = null;
			if (borderColor != null)
				msgs = ((InternalEObject)borderColor).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR, null, msgs);
			if (newBorderColor != null)
				msgs = ((InternalEObject)newBorderColor).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR, null, msgs);
			msgs = basicSetBorderColor(newBorderColor, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR, newBorderColor, newBorderColor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getPadding() {
		return padding;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPadding(double newPadding) {
		double oldPadding = padding;
		padding = newPadding;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__PADDING, oldPadding, padding));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getPaddingTop() {
		return paddingTop;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaddingTop(double newPaddingTop) {
		double oldPaddingTop = paddingTop;
		paddingTop = newPaddingTop;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__PADDING_TOP, oldPaddingTop, paddingTop));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getPaddingLeft() {
		return paddingLeft;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaddingLeft(double newPaddingLeft) {
		double oldPaddingLeft = paddingLeft;
		paddingLeft = newPaddingLeft;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__PADDING_LEFT, oldPaddingLeft, paddingLeft));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getPaddingBottom() {
		return paddingBottom;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaddingBottom(double newPaddingBottom) {
		double oldPaddingBottom = paddingBottom;
		paddingBottom = newPaddingBottom;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__PADDING_BOTTOM, oldPaddingBottom, paddingBottom));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public double getPaddingRight() {
		return paddingRight;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setPaddingRight(double newPaddingRight) {
		double oldPaddingRight = paddingRight;
		paddingRight = newPaddingRight;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__PADDING_RIGHT, oldPaddingRight, paddingRight));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UColor getBackgroundColor() {
		if (backgroundColor != null && backgroundColor.eIsProxy()) {
			InternalEObject oldBackgroundColor = (InternalEObject)backgroundColor;
			backgroundColor = (UColor)eResolveProxy(oldBackgroundColor);
			if (backgroundColor != oldBackgroundColor) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, OptionsPackage.BOX_MODEL_OPTION__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor));
			}
		}
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public UColor basicGetBackgroundColor() {
		return backgroundColor;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBackgroundColor(UColor newBackgroundColor) {
		UColor oldBackgroundColor = backgroundColor;
		backgroundColor = newBackgroundColor;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BACKGROUND_COLOR, oldBackgroundColor, backgroundColor));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isKeepTogether() {
		return keepTogether;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeepTogether(boolean newKeepTogether) {
		boolean oldKeepTogether = keepTogether;
		keepTogether = newKeepTogether;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__KEEP_TOGETHER, oldKeepTogether, keepTogether));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isKeepWithPrevious() {
		return keepWithPrevious;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeepWithPrevious(boolean newKeepWithPrevious) {
		boolean oldKeepWithPrevious = keepWithPrevious;
		keepWithPrevious = newKeepWithPrevious;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS, oldKeepWithPrevious, keepWithPrevious));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isKeepWithNext() {
		return keepWithNext;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setKeepWithNext(boolean newKeepWithNext) {
		boolean oldKeepWithNext = keepWithNext;
		keepWithNext = newKeepWithNext;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_NEXT, oldKeepWithNext, keepWithNext));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBreakBefore() {
		return breakBefore;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreakBefore(boolean newBreakBefore) {
		boolean oldBreakBefore = breakBefore;
		breakBefore = newBreakBefore;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BREAK_BEFORE, oldBreakBefore, breakBefore));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setWidth(int newWidth) {
		int oldWidth = width;
		width = newWidth;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__WIDTH, oldWidth, width));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isBreakAfter() {
		return breakAfter;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setBreakAfter(boolean newBreakAfter) {
		boolean oldBreakAfter = breakAfter;
		breakAfter = newBreakAfter;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, OptionsPackage.BOX_MODEL_OPTION__BREAK_AFTER, oldBreakAfter, breakAfter));
	}

	// custom code begin
	/**
	 * {@inheritDoc}
	 */
	public void setBackgroundColor(Color color) {
		UColor uColor = OptionsFactory.eINSTANCE.createUColor();
		uColor.setRed(color.getRed());
		uColor.setGreen(color.getGreen());
		uColor.setBlue(color.getBlue());

		setBackgroundColor(uColor);
	}

	// custom code end

	/**
	 * <!-- begin-user-doc --> . <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR:
				return basicSetBorderColor(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN:
				return getMargin();
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_TOP:
				return getMarginTop();
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_LEFT:
				return getMarginLeft();
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_BOTTOM:
				return getMarginBottom();
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_RIGHT:
				return getMarginRight();
			case OptionsPackage.BOX_MODEL_OPTION__BORDER:
				return getBorder();
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_TOP:
				return getBorderTop();
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_LEFT:
				return getBorderLeft();
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_BOTTOM:
				return getBorderBottom();
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_RIGHT:
				return getBorderRight();
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_STYLE:
				return getBorderStyle();
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR:
				return getBorderColor();
			case OptionsPackage.BOX_MODEL_OPTION__PADDING:
				return getPadding();
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_TOP:
				return getPaddingTop();
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_LEFT:
				return getPaddingLeft();
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_BOTTOM:
				return getPaddingBottom();
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_RIGHT:
				return getPaddingRight();
			case OptionsPackage.BOX_MODEL_OPTION__BACKGROUND_COLOR:
				if (resolve) return getBackgroundColor();
				return basicGetBackgroundColor();
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_TOGETHER:
				return isKeepTogether();
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS:
				return isKeepWithPrevious();
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_NEXT:
				return isKeepWithNext();
			case OptionsPackage.BOX_MODEL_OPTION__BREAK_BEFORE:
				return isBreakBefore();
			case OptionsPackage.BOX_MODEL_OPTION__WIDTH:
				return getWidth();
			case OptionsPackage.BOX_MODEL_OPTION__BREAK_AFTER:
				return isBreakAfter();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN:
				setMargin((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_TOP:
				setMarginTop((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_LEFT:
				setMarginLeft((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_BOTTOM:
				setMarginBottom((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_RIGHT:
				setMarginRight((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER:
				setBorder((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_TOP:
				setBorderTop((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_LEFT:
				setBorderLeft((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_BOTTOM:
				setBorderBottom((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_RIGHT:
				setBorderRight((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_STYLE:
				setBorderStyle((UBorderStyle)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR:
				setBorderColor((UColor)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING:
				setPadding((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_TOP:
				setPaddingTop((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_LEFT:
				setPaddingLeft((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_BOTTOM:
				setPaddingBottom((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_RIGHT:
				setPaddingRight((Double)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BACKGROUND_COLOR:
				setBackgroundColor((UColor)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_TOGETHER:
				setKeepTogether((Boolean)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS:
				setKeepWithPrevious((Boolean)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_NEXT:
				setKeepWithNext((Boolean)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BREAK_BEFORE:
				setBreakBefore((Boolean)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__WIDTH:
				setWidth((Integer)newValue);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BREAK_AFTER:
				setBreakAfter((Boolean)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN:
				setMargin(MARGIN_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_TOP:
				setMarginTop(MARGIN_TOP_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_LEFT:
				setMarginLeft(MARGIN_LEFT_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_BOTTOM:
				setMarginBottom(MARGIN_BOTTOM_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_RIGHT:
				setMarginRight(MARGIN_RIGHT_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER:
				setBorder(BORDER_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_TOP:
				setBorderTop(BORDER_TOP_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_LEFT:
				setBorderLeft(BORDER_LEFT_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_BOTTOM:
				setBorderBottom(BORDER_BOTTOM_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_RIGHT:
				setBorderRight(BORDER_RIGHT_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_STYLE:
				setBorderStyle(BORDER_STYLE_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR:
				setBorderColor((UColor)null);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING:
				setPadding(PADDING_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_TOP:
				setPaddingTop(PADDING_TOP_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_LEFT:
				setPaddingLeft(PADDING_LEFT_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_BOTTOM:
				setPaddingBottom(PADDING_BOTTOM_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_RIGHT:
				setPaddingRight(PADDING_RIGHT_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BACKGROUND_COLOR:
				setBackgroundColor((UColor)null);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_TOGETHER:
				setKeepTogether(KEEP_TOGETHER_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS:
				setKeepWithPrevious(KEEP_WITH_PREVIOUS_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_NEXT:
				setKeepWithNext(KEEP_WITH_NEXT_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BREAK_BEFORE:
				setBreakBefore(BREAK_BEFORE_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__WIDTH:
				setWidth(WIDTH_EDEFAULT);
				return;
			case OptionsPackage.BOX_MODEL_OPTION__BREAK_AFTER:
				setBreakAfter(BREAK_AFTER_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN:
				return margin != MARGIN_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_TOP:
				return marginTop != MARGIN_TOP_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_LEFT:
				return marginLeft != MARGIN_LEFT_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_BOTTOM:
				return marginBottom != MARGIN_BOTTOM_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__MARGIN_RIGHT:
				return marginRight != MARGIN_RIGHT_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER:
				return border != BORDER_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_TOP:
				return borderTop != BORDER_TOP_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_LEFT:
				return borderLeft != BORDER_LEFT_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_BOTTOM:
				return borderBottom != BORDER_BOTTOM_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_RIGHT:
				return borderRight != BORDER_RIGHT_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_STYLE:
				return borderStyle != BORDER_STYLE_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BORDER_COLOR:
				return borderColor != null;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING:
				return padding != PADDING_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_TOP:
				return paddingTop != PADDING_TOP_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_LEFT:
				return paddingLeft != PADDING_LEFT_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_BOTTOM:
				return paddingBottom != PADDING_BOTTOM_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__PADDING_RIGHT:
				return paddingRight != PADDING_RIGHT_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BACKGROUND_COLOR:
				return backgroundColor != null;
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_TOGETHER:
				return keepTogether != KEEP_TOGETHER_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_PREVIOUS:
				return keepWithPrevious != KEEP_WITH_PREVIOUS_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__KEEP_WITH_NEXT:
				return keepWithNext != KEEP_WITH_NEXT_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BREAK_BEFORE:
				return breakBefore != BREAK_BEFORE_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__WIDTH:
				return width != WIDTH_EDEFAULT;
			case OptionsPackage.BOX_MODEL_OPTION__BREAK_AFTER:
				return breakAfter != BREAK_AFTER_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (margin: ");
		result.append(margin);
		result.append(", marginTop: ");
		result.append(marginTop);
		result.append(", marginLeft: ");
		result.append(marginLeft);
		result.append(", marginBottom: ");
		result.append(marginBottom);
		result.append(", marginRight: ");
		result.append(marginRight);
		result.append(", border: ");
		result.append(border);
		result.append(", borderTop: ");
		result.append(borderTop);
		result.append(", borderLeft: ");
		result.append(borderLeft);
		result.append(", borderBottom: ");
		result.append(borderBottom);
		result.append(", borderRight: ");
		result.append(borderRight);
		result.append(", borderStyle: ");
		result.append(borderStyle);
		result.append(", padding: ");
		result.append(padding);
		result.append(", paddingTop: ");
		result.append(paddingTop);
		result.append(", paddingLeft: ");
		result.append(paddingLeft);
		result.append(", paddingBottom: ");
		result.append(paddingBottom);
		result.append(", paddingRight: ");
		result.append(paddingRight);
		result.append(", keepTogether: ");
		result.append(keepTogether);
		result.append(", keepWithPrevious: ");
		result.append(keepWithPrevious);
		result.append(", keepWithNext: ");
		result.append(keepWithNext);
		result.append(", breakBefore: ");
		result.append(breakBefore);
		result.append(", width: ");
		result.append(width);
		result.append(", breakAfter: ");
		result.append(breakAfter);
		result.append(')');
		return result.toString();
	}

} // BoxModelOptionImpl
