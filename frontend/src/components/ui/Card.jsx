export function Card({ children, className = '' }) {
    return (
      <div className={`rounded-xl shadow-lg p-4 sm:p-6 lg:p-8 ${className}`}>
        {children}
      </div>
    );
  }