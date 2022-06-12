/**
 */
package metamodelHCL.util;

import metamodelHCL.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see metamodelHCL.MetamodelHCLPackage
 * @generated
 */
public class MetamodelHCLAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static MetamodelHCLPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MetamodelHCLAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = MetamodelHCLPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject) object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MetamodelHCLSwitch<Adapter> modelSwitch = new MetamodelHCLSwitch<Adapter>() {
		@Override
		public Adapter caseComponent(Component object) {
			return createComponentAdapter();
		}

		@Override
		public Adapter caseProcessing(Processing object) {
			return createProcessingAdapter();
		}

		@Override
		public Adapter caseStorage(Storage object) {
			return createStorageAdapter();
		}

		@Override
		public Adapter caseDisplay(Display object) {
			return createDisplayAdapter();
		}

		@Override
		public Adapter caseReusedComponent(ReusedComponent object) {
			return createReusedComponentAdapter();
		}

		@Override
		public Adapter caseProcessingProperty(ProcessingProperty object) {
			return createProcessingPropertyAdapter();
		}

		@Override
		public Adapter caseStorageProperty(StorageProperty object) {
			return createStoragePropertyAdapter();
		}

		@Override
		public Adapter caseDisplayProperty(DisplayProperty object) {
			return createDisplayPropertyAdapter();
		}

		@Override
		public Adapter caseCores(Cores object) {
			return createCoresAdapter();
		}

		@Override
		public Adapter caseSpeed(Speed object) {
			return createSpeedAdapter();
		}

		@Override
		public Adapter caseCache(Cache object) {
			return createCacheAdapter();
		}

		@Override
		public Adapter caseL1(L1 object) {
			return createL1Adapter();
		}

		@Override
		public Adapter caseL2(L2 object) {
			return createL2Adapter();
		}

		@Override
		public Adapter caseL3(L3 object) {
			return createL3Adapter();
		}

		@Override
		public Adapter caseSingleStorage(SingleStorage object) {
			return createSingleStorageAdapter();
		}

		@Override
		public Adapter caseDiagonal(Diagonal object) {
			return createDiagonalAdapter();
		}

		@Override
		public Adapter caseType(Type object) {
			return createTypeAdapter();
		}

		@Override
		public Adapter caseComputer(Computer object) {
			return createComputerAdapter();
		}

		@Override
		public Adapter defaultCase(EObject object) {
			return createEObjectAdapter();
		}
	};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject) target);
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Component
	 * @generated
	 */
	public Adapter createComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Processing <em>Processing</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Processing
	 * @generated
	 */
	public Adapter createProcessingAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Storage <em>Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Storage
	 * @generated
	 */
	public Adapter createStorageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Display <em>Display</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Display
	 * @generated
	 */
	public Adapter createDisplayAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.ReusedComponent <em>Reused Component</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.ReusedComponent
	 * @generated
	 */
	public Adapter createReusedComponentAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.ProcessingProperty <em>Processing Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.ProcessingProperty
	 * @generated
	 */
	public Adapter createProcessingPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.StorageProperty <em>Storage Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.StorageProperty
	 * @generated
	 */
	public Adapter createStoragePropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.DisplayProperty <em>Display Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.DisplayProperty
	 * @generated
	 */
	public Adapter createDisplayPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Cores <em>Cores</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Cores
	 * @generated
	 */
	public Adapter createCoresAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Speed <em>Speed</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Speed
	 * @generated
	 */
	public Adapter createSpeedAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Cache <em>Cache</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Cache
	 * @generated
	 */
	public Adapter createCacheAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.L1 <em>L1</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.L1
	 * @generated
	 */
	public Adapter createL1Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.L2 <em>L2</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.L2
	 * @generated
	 */
	public Adapter createL2Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.L3 <em>L3</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.L3
	 * @generated
	 */
	public Adapter createL3Adapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.SingleStorage <em>Single Storage</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.SingleStorage
	 * @generated
	 */
	public Adapter createSingleStorageAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Diagonal <em>Diagonal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Diagonal
	 * @generated
	 */
	public Adapter createDiagonalAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Type <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Type
	 * @generated
	 */
	public Adapter createTypeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link metamodelHCL.Computer <em>Computer</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see metamodelHCL.Computer
	 * @generated
	 */
	public Adapter createComputerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //MetamodelHCLAdapterFactory
