export function Input({ 
    label, 
    error, 
    type = 'text',
    className = '',
    ...props 
  }) {
    return (
      <div className="w-full">
        {label && (
          <label className="block text-sm font-medium text-foreground mb-1">
            {label}
          </label>
        )}
        <input
          type={type}
          className={`
            w-full px-3 py-2.5 sm:px-4 sm:py-3 border rounded-lg 
            text-sm sm:text-base
            focus:ring-2 focus:ring-primary focus:border-transparent
            transition-all duration-200
            ${error ? 'border-red-500' : 'border-gray-500'}
            ${className}
          `}
          {...props}
        />
        {error && (
          <p className="mt-1 text-sm text-red-500">{error}</p>
        )}
      </div>
    );
  }